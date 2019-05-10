import Vue from 'vue';
import { Router } from 'vue-components';
const HelloWorld = () => import('@/components/HelloWorld');
const BackGround = () => import('@/components/background/BackGround');
const music = () => import('@/components/music/Music');
const wy = () => import('@/components/music/WyMusic');
const layout = () => import('@/components/layout/LayOut');
const markdown = () => import('@/components/markdown/MarkDown');
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
        },
        {
            path: '/test',
            name: 'test',
            component: BackGround
        },
        {
            path: '/test1', // *
            name: 'test1',
            component: music
        },
        {
            path: '/test2', // *
            name: 'test2',
            component: wy
        },
        {
            path: '/test3', // *
            name: 'test3',
            component: markdown
        },
        {
            path: '/layout', // *
            name: 'layout',
            component: layout
        }
    ]
});
