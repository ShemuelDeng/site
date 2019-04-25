import Vue from 'vue';
import { Router } from 'vue-components';
const HelloWorld = () => import('@/components/HelloWorld');

Vue.use(Router());
// 必须以根目录配置路由，base必须填
export default new Router({
    mode: 'history',
    // 项目名，与config/index.js中配置的项目名一致
    routes: [
        {
            path: '/index',
            name: 'Index',
            component: HelloWorld
        }
    ]
});
