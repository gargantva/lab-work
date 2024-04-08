<template>
<header>
  <span style="width: 15.625vw;height: 3.241vh;font-size: 1.5625vw;font-family: FZLTCHJW--GB1-0, FZLTCHJW--GB1;
font-weight: normal;color: #FFFFFF;line-height: 35px;position: absolute;top: 1.111vh;left: 1.042vw;">水质监测系统后台管理</span>
  <div style="position: absolute; right: 1.458vw;top: 1.852vh;">
    <span style="margin-left: 0.521vw;position: absolute;top:0.648vh;left:1.042vw;width:3.125vw;font-size: 0.885vw">Admin</span>
    <el-dropdown trigger="click" @command="handleUser">
       <span class="el-dropdown-link">
      <img :src="headImg" style="margin-left: 5.208vw;margin-top: 0.463vh" >
      </span>
      <el-dropdown-menu slot="dropdown">
        <el-dropdown-item command="a">登出</el-dropdown-item>
      </el-dropdown-menu>
    </el-dropdown>
  </div>


</header>
</template>

<script>
  import bg from '../assets/loginImg/LoginOut.png'
    export default {
      name: "CommonHeader",
      data(){
        return{
        headImg:bg
        }
      },
      computed: {
        breadCrumbList() {
          return this.$route.matched;
        }
      },
      created() {
        this.loadImg()
      },
      methods: {
        loadImg(){
          // this.headImg=this.$store.state.headImg;
        },
        handleUser(command){
          // if(command=='a') this.logout();
        },
        // logout(){
        //   this.$store.commit('set_token','');
        //   let headImg='';
        //   let nickName='';
        //   this.$store.commit('set_user',{headImg,nickName});
        //   let url = '/chscent/authc/loginOut';
        //   this.$http.get(url).then(({data:res})=> {
        //     if (res.status == 200) {
        //       this.$router.push({
        //         path:'/login',
        //       });
        //      return this.$message.success('退出成功')
        //     } else {
        //       console.log('退出异常');
        //     }
        //   });
        //
        // },
      }
    }
</script>

<style lang="less" scoped>
  header{
    width:100vw;
    height: 7.46vh;
    background-image:url("../assets/pageImage/header.png");
    box-shadow: 0px 3px 6px 1px rgba(192,192,192,0.07);
    opacity: 1;

  }

  span{
    color: #FFFFFF;
  }

  /deep/ .el-breadcrumb__item:last-child .el-breadcrumb__inner{
    color: #ffffff;
    font-size: 1.042vw;
  }

  /deep/ .el-breadcrumb__separator {
    color: #ecf5ff;
    font-size: 1.042vw;
  }

  .el-dropdown-menu {
    left: 93.75vw !important;
  }

</style>
