<template>
  <el-menu>
    <el-menu-item @click="linkToIndex" index="1" style="margin-top: 1.852vh;">
      <img class="titleImg" src="../assets/navMenu/index.png"/>
      <span slot="title">首页</span>
    </el-menu-item>
    <el-menu-item @click="linkToUser" index="2">
      <img class="titleImg" src="../assets/navMenu/user.png"/>
      <span slot="title">用户管理</span>
    </el-menu-item>
    <el-menu-item @click="linkToWaterBaseInfo" index="3">
      <img class="titleImg" src="../assets/navMenu/waterBaseInfo.png"/>
      <span slot="title">河道基础信息数据</span>
    </el-menu-item>
    <el-menu-item @click="linkToWaterWeekData" index="4">
      <img class="titleImg" src="../assets/navMenu/waterData.png"/>
      <span slot="title">周测水质数据</span>
    </el-menu-item>
    <el-menu-item @click="linkToWaterMonthData" index="5">
      <img class="titleImg" src="../assets/navMenu/waterData.png"/>
      <span slot="title">月测水质数据</span>
    </el-menu-item>
    <el-menu-item @click="linkToWaterPoint" index="6">
      <img class="titleImg" src="../assets/navMenu/waterPoint.png"/>
      <span slot="title">水文站点数据</span>
    </el-menu-item>
  </el-menu>
</template>

<script>
    export default {
        name: "CommonAside",
        methods:{
          linkToIndex(){
            this.$router.push('/index');
          },
          linkToUser(){
              this.$router.push('/user');
          },
          linkToWaterBaseInfo(){
            this.$router.push('/waterBaseInfo');
          },
          linkToWaterWeekData(){
            this.$router.push('/waterWeekData');
          },
          linkToWaterMonthData(){
            this.$router.push('/waterMonthData');
          },
          linkToWaterPoint(){
            this.$router.push('/waterPoint');
          },
          linkToMessage(){
            this.$router.push('/message');
          },
          linkToLine(){
            this.$router.push('/lineManage');
          },
          linkToAlarm(){
            this.$router.push('/alarmLog');
          },
          linkToScreen(){
            this.$router.push('/screen');
          }
        }
    }
</script>

<style lang="less" scoped>
  .title1{
    text-align: center;
    background-color: #0078DD;
  }
  i{
    position: absolute;
    right: 1.042vw;
    top: 1.852vh;

  }

  h3 {
    width: 11.458vw;
    height:2.778vh;
    font-size: 0.729vw;
    font-family: Source Han Sans CN-Medium, Source Han Sans CN;
    font-weight: 500;
    color: #ffffff;
    line-height: 0px;
    text-align: center;
    /*-webkit-background-clip: text;*/
    /*-webkit-text-fill-color: transparent;*/

  }

  .el-menu {
    border-right: 0;
    width: 12.5vw;
    height: 92.7vh;
    background: #0E1D43;
    border-radius: 0px 0px 0px 0px;
    opacity: 1;
  }

  .el-menu-item{
    margin-bottom: 1.852vh;
    margin-left: 0.521vw;
    width: 11.458vw;
    height: 5.556vh;
    color:#FFFFFF ;
    font-size: 0.9375vw;
    /*background: #FFFFFF;*/
    border-radius: 4px 4px 4px 4px;
    opacity: 1;
  }
  .el-menu-item.is-active {
    color: #409EFF;
  }

  .title{
    width: 5vw;
    height: 2.87vh;
    font-size: 1.25vw;
    font-family: Microsoft YaHei-Regular, Microsoft YaHei;
    font-weight: 400;
    color: #FFFFFF;
    line-height: 0px;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
  }

  .titleImg{
    width: 1.302vw;
    height: 2.315vh;
    /*background: #447CB4;*/
    opacity: 1;
    margin-right: 0.521vw;
  }

  /*鼠标移动到菜单颜色*/
  .el-menu-item:focus, .el-menu-item:hover {
       outline: 0;
       background-color: #66b1ff69;
     }

</style>
