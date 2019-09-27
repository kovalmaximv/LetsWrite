const React = require('react');
const ReactDOM = require('react-dom');
const axios = require('axios');

import MyAppBar from './appbar/appbar';

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {posts: []};
    }

    componentDidMount() {
        axios.get('/posts').then(response => this.setState({posts: response.data}));
    }

    render(){
        return (
            <PostsList posts={this.state.posts}/>
        )
    }
}

class PostsList extends React.Component {
    render() {
        const posts = this.props.posts.map(post =>
            <Post key={post.id} post={post}/>
        );
        return (
            <div>
                <MyAppBar />
                <table>
                    <tbody>
                    <tr>
                        <th>Theme</th>
                        <th>Description</th>
                        <th>Text</th>
                    </tr>
                    {posts}
                    </tbody>
                </table>
            </div>
        )
    }
}

class Post extends React.Component {
    render() {
        return (
            <tr>
                <td>{this.props.post.theme}</td>
                <td>{this.props.post.description}</td>
                <td>{this.props.post.text}</td>
            </tr>
        )
    }
}

ReactDOM.render(
    <App />,
    document.getElementById('react')
)