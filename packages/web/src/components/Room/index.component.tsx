import React, {ChangeEvent, Component, PureComponent} from 'react';
import {TProps} from './index.interfaces';
import {MessageTO} from '../../api/__generated__';

interface State {
    message: string;
}

class RoomMessage extends PureComponent<{message: MessageTO}> {
    render() {
        return (
            <div>
                [<span>{this.props.message.timestamp.toString()}</span>]
                <span>{this.props.message.userId}</span>:
                <span>{this.props.message.body}</span>
            </div>
        );
    }
}

export default class Room extends Component<TProps, State> {

    state = {
        message: '',
    };

    componentDidMount() {
        this.props.onJoin(this.props.roomId);
    }

    componentWillUnmount() {
        this.props.onUnjoin();
    }

    render() {
        return (
            <div>
                <div>
                    Room {this.props.roomId}
                </div>
                <div>
                    {this.props.messages.map(message => <RoomMessage key={message.id} message={message}/>)}
                </div>
                <div>
                    <input
                        onChange={this.handleChange}
                        value={this.state.message}
                    />
                    <button onClick={this.handleSubmit}>Send</button>
                </div>
            </div>
        );
    }

    private readonly handleChange = (ev: ChangeEvent<HTMLInputElement>) => {
        this.setState({message: ev.target.value});
    };

    private readonly handleSubmit = () => {
        this.props.onSend({
            id: '',
            roomId: this.props.roomId,
            userId: this.props.userId,
            body: this.state.message,
        });
        this.setState({message: ''});
    };
}
