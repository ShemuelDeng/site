'use strict';
// Template version: 1.3.1
// see http://vuejs-templates.github.io/webpack for documentation.

const path = require('path');

// 项目名 必须配置
const contextPath = '';

// 代理配置
const proxyTable = {
    // 公共方法接口反向代理，请修改target为本项目url
    '/common/': {
        // 代理url
        target: `http://localhost:5555${contextPath}`,
        changeOrigin: true,
        // 重写规则
        pathRewrite: {}
    },
    '/consumer/': {
        // 代理url
        target: `http://39.106.70.195`,
        changeOrigin: true,
        // 重写规则
        pathRewrite: {}
    }
};
// 遍历过程请勿修改
for (let proxyTableKey in proxyTable) {
    if (contextPath) {
        proxyTable[contextPath + proxyTableKey] = proxyTable[proxyTableKey];
        proxyTable[contextPath + proxyTableKey].pathRewrite = proxyTable[contextPath + proxyTableKey].pathRewrite || {};
        proxyTable[contextPath + proxyTableKey].pathRewrite[`^${contextPath}`] = '';
        delete proxyTable[proxyTableKey];
    }
}
module.exports = {
    dev: {
        // Paths
        assetsSubDirectory: 'static',
        assetsPublicPath: '/',
        // 反向代理匹配规则
        // 务必修改此处内容
        proxyTable: proxyTable,
        // 热加载
        hot: true,
        // Various Dev Server settings
        // 没有特殊需要尽量不要修改host，0.0.0.0可以通过localhost或者ip进行访问
        host: '0.0.0.0', // can be overwritten by process.env.HOST
        port: 8080, // can be overwritten by process.env.PORT, if port is in use, a free one will be determined
        autoOpenBrowser: false, // open index url when run 'npm run dev'
        errorOverlay: true,
        notifyOnErrors: true,
        poll: false, // https://webpack.js.org/configuration/dev-server/#devserver-watchoptions-
        /**
         * Source Maps
         */
        // https://webpack.js.org/configuration/devtool/#development
        devtool: 'cheap-module-eval-source-map',
        // If you have problems debugging vue-files in devtools,
        // set this to false - it *may* help
        // https://vue-loader.vuejs.org/en/options.html#cachebusting
        cacheBusting: true,
        cssSourceMap: true
    },
    build: {
        // Template for index.html
        index: path.resolve(__dirname, '../public/index.html'),
        // Paths
        assetsRoot: path.resolve(__dirname, '../public'),
        assetsSubDirectory: '',
        assetsPublicPath: '',
        /**
         * Source Maps
         */
        productionSourceMap: false,
        // https://webpack.js.org/configuration/devtool/#production
        devtool: '#source-map',
        // Gzip off by default as many popular static hosts such as
        // Surge or Netlify already gzip all static assets for you.
        // Before setting to `true`, make sure to:
        // npm install --save-dev compression-webpack-plugin
        productionGzip: false,
        productionGzipExtensions: ['js', 'css'],
        // Run the build command with an extra argument to
        // View the bundle analyzer report after build finishes:
        // `npm run build --report`
        // Set to `true` or `false` to always turn it on or off
        bundleAnalyzerReport: process.env.npm_config_report
    }
};
