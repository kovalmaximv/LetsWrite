var path = require('path');

module.exports = {
    entry: path.join(__dirname, 'src', 'main', 'resources', 'static', 'js', 'main.js'),
    devtool: 'sourcemaps',
    cache: true,
    mode: 'development',
    devServer: {
        contentBase: './dist',
        compress: true,
        port: 8000,
        allowedHosts: [
            'localhost:9000'
        ]
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /(node_modules|bower_components)/,
                use: [{
                    loader: 'babel-loader',
                    options: {
                        presets: ["@babel/preset-env", "@babel/preset-react"]
                    }
                }]
            }
        ]
    },
    resolve:{
        modules:[
            path.join(__dirname, 'src', 'main', 'resources', 'static', 'js'),
            path.join(__dirname, 'node_modules')
        ]
    }
};