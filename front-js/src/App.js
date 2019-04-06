import React, {Component} from 'react';
import {BrowserRouter as Router, Route} from "react-router-dom";
import Header from "./components/Header";
import Hello from "./components/Hello";
import Room from "./components/Room";

class App extends Component {
    render() {
        return (
            <Router>
                <Header/>
                <Route exact path='/' component={Hello}/>
                <Route path={`/:roomId`}
                       component={
                           (props) =>
                               <Room roomId={props.match.params.roomId}/>
                       }
                />
            </Router>
        );
    }
}

export default App;
