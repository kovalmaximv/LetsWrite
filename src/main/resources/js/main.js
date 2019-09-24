const React = require('react');
const ReactDOM = require('react-dom');
const client = require('rest'); //rest.js

class App extends React.Component {
    constructor(props) {
        super(props);
        this.state = {posts: []};
    }

    componentDidMount() {
        client({method: 'GET', path: '/posts'}).done(response => {
            this.setState({posts: response.entity._embedded.posts});
        });
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
            <Post key={post._links.self.href} post={post}/>
        );
        return (
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