import Vue from 'vue'
import Router from 'vue-router'
// import Main from '../view/Main'
// import Login from '../view/Login'

Vue.use(Router)

const routes=[
  {
    path: '/',
    name: 'MainScreen',
    component: () => import('../view/screen/MainScreen.vue'),
    redirect:'/IndexScreen',
    children:[
      {
        path: 'IndexScreen',
        name: 'IndexScreen',
        component: () => import('../view/screen/IndexScreen.vue'),
      },
      {
        path: 'DeviceDetailsScreen',
        name: 'DeviceDetailsScreen',
        component: () => import('../view/screen/DeviceDetailsScreen.vue'),
      },
      {
        path: 'DeviceManagementScreen',
        name: 'DeviceManagementScreen',
        component: () => import('../view/screen/DeviceManagementScreen.vue'),
      },

    ]
  }
];

const router= new Router({
  mode:'hash',
  routes
});

const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch(err => err)
};

export default router
