import Vue from 'vue';
import Vuex from 'vuex';
import createPersistedState from 'vuex-persistedstate'

Vue.use(Vuex);
const state={//eslint-disable-line no-unused-vars
  isCollapse:false
}

export default new Vuex.Store({
  plugins: [createPersistedState({storage: window.localStorage})],
  state:{
    token:false,
    headImg:'',
    nickName:''
  },
  mutations: {
    set_token(state, token) {
      state.token = token
    },
    // set_user(state,{headImg,nickName}){
    //   state.headImg=headImg;
    //   state.nickName=nickName;
    // }
  },
  strict: false
});
