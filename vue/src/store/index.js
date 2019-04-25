import Vue from 'vue';
import { Vuex } from 'vue-components';
import { empty } from './modules/empty';

Vue.use(Vuex);
// 全局状态

// 只读属性
const state = () => {
    return {};
};

// getters
const getters = {
    // fn(state){}
};

// setters and other operations
const mutations = {
    // fn(state,payload)
};

// async operations
// ajax query、remove、update、insert
// must return $http
const actions = {
    // fn(context,payload){}
    /* context = {
     state,      // 等同于 `store.state`，若在模块中则为局部状态
     rootState,  // 等同于 `store.state`，只存在于模块中
     commit,     // 等同于 `store.commit`
     dispatch,   // 等同于 `store.dispatch`
     getters,    // 等同于 `store.getters`
     rootGetters // 等同于 `store.getters`，只存在于模块中
     }
     通过解构赋值直接使用
     fn({state},payload){}
     */
};

// children modules
const modules = {
    empty
};

const store = new Vuex.Store({
    strict: process.env.NODE_ENV !== 'production',
    state,
    getters,
    mutations,
    actions,
    modules
});

export default store;
