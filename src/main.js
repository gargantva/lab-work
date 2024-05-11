// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from "./vuex"
import axios from "axios";
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import qs from  'qs';

import * as echarts from 'echarts';

Vue.config.productionTip = false;


Vue.use(ElementUI);

Vue.prototype.$http = axios;
Vue.prototype.$qs = qs;

Vue.prototype.$echarts = echarts;

Vue.use(echarts);
// router.beforeEach((to, from, next) => {
//   if (to.meta.requireAuth) {// 判断该路由是否需要登录权限
//     var timestamp = (new Date()).valueOf();
//     if (store.state.token&&(timestamp-store.state.token)<6500000) {  // 通过vuex state获取当前的token是否存在,且是否在时间内
//       next();
//     }
//     else {
//       store.commit('set_token','');
//       next({
//         path: '/login',
//         query: {redirect: to.fullPath}  // 将跳转的路由path作为参数，登录成功后跳转到该路由
//       })
//     }
//   }
//   else {
//     next();
//   }
// })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
