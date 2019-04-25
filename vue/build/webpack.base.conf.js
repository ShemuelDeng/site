'use strict';
const path = require('path');
const utils = require('./utils');
const config = require('../config');
const vueLoaderConfig = require('./vue-loader.conf');
const getTimeStamp = utils.getTimeStamp();

function resolve (dir) {
    return path.join(__dirname, '..', dir);
}

module.exports = {
    // 配置根目录
    //     __dirname 当前文件的绝对路径
    //     配置当前文件上一层为根目录
    context: path.resolve(__dirname, '../'),
    // 入口文件
    //     有需要可以配置多个入口文件，每一个文件最终生成一个chunk，chunk名字是entry的key
    entry: {
        app: './src/main.js'
    },
    // 输出
    output: {
        path: config.build.assetsRoot,
        filename: '[name].js',
        publicPath: process.env.NODE_ENV === 'production'
            ? config.build.assetsPublicPath
            : config.dev.assetsPublicPath
    },
    resolve: {
        // 以下文件解析时不用带后缀
        extensions: ['.js', '.css', '.vue', '.json'],
        alias: {
            'vue$': 'vue/dist/vue.esm.js',
            '@': resolve('src')
        }
    },
    module: {
        rules: [
            {
                // 匹配js和vue文件
                test: /\.(js|vue)$/,
                // 使用eslint-loader解析，多个loader使用use，传入loader数组，从后往前解析
                loader: 'eslint-loader',
                // loader执行顺序最先
                enforce: 'pre',
                // 解析文件路径
                include: [resolve('src'), resolve('test')],
                // 不解析的文件路径
                exclude: resolve('../node_modules'),
                options: {
                    formatter: require('eslint-friendly-formatter')
                }
            },
            {
                test: /\.vue$/,
                loader: 'vue-loader',
                exclude: resolve('../node_modules'),
                options: vueLoaderConfig
            },
            {
                test: /\.js$/,
                loader: 'babel-loader?cacheDirectory',
                exclude: resolve('../node_modules'),
                include: [resolve('src'), resolve('test'), resolve('node_modules/webpack-dev-server/client')]
            },
            {
                test: /\.(png|jpe?g|gif|svg)(\?.*)?$/,
                loader: 'url-loader',
                exclude: resolve('../node_modules'),
                options: {
                    limit: 10000,
                    name: utils.assetsPath(`img/[name].[ext]?_t=${getTimeStamp}`)
                }
            },
            {
                test: /\.(mp4|webm|ogg|mp3|wav|flac|aac)(\?.*)?$/,
                loader: 'file-loader',
                exclude: resolve('../node_modules'),
                options: {
                    limit: 10000,
                    name: utils.assetsPath(`media/[name].[ext]?_t=${getTimeStamp}`)
                }
            },
            {
                test: /\.(woff2?|eot|ttf|otf)(\?.*)?$/,
                loader: 'file-loader',
                exclude: resolve('../node_modules'),
                options: {
                    limit: 10000,
                    name: utils.assetsPath(`fonts/[name].[ext]?_t=${getTimeStamp}`)
                }
            }
        ]
    },
    node: {
        // prevent webpack from injecting useless setImmediate polyfill because Vue
        // source contains it (although only uses it if it's native).
        setImmediate: false,
        // prevent webpack from injecting mocks to Node native modules
        // that does not make sense for the client
        dgram: 'empty',
        fs: 'empty',
        net: 'empty',
        tls: 'empty',
        child_process: 'empty'
    }
};
