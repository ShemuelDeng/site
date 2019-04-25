// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.

// 没有特殊需求，尽量不修改此js，布局移步App.vue进行构建
import 'babel-polyfill';
import Vue from 'vue';
import { iview, elementUI } from 'vue-components';
import common from 'vue-components';
import App from './App';
import router from './router';
import store from './store';

// 对权限进行控制
// import { authorityControl } from 'vue-components';

Vue.use(common);
Vue.use(iview);
Vue.use(elementUI);

Vue.config.productionTip = false;
/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    store,
    components: { App },
    // 需要控制权限时打开此注释
    // mixins: [authorityControl],
    created: function () {
        // 404页面跳转时需要的url，请保留
        // this.getNavigationUrl();
        // 加载主题文件，请勿修改
        // this.loadTheme();
    },
    template: '<App/>'
});
