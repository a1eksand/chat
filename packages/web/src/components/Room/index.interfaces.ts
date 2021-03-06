import {onJoin, onUnjoin, onSend} from '../../data/chat';
import {MessageTO} from '../../api/__generated__';

export interface TOwnProps {
    roomId: string;
}

export type IStateToProps = {
    messages: MessageTO[];
    userId: string;
};

export interface IDispatchToProps {
    onJoin: typeof onJoin;
    onUnjoin: typeof onUnjoin;
    onSend: typeof onSend;
}

export type TProps = TOwnProps & IStateToProps & IDispatchToProps;
