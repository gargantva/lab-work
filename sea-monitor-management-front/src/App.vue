<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>
#app {
  height: 100vh;
}
body{
  margin: 0;
}

/*!*滚动条美化*!*/
/*div::-webkit-scrollbar {!*滚动条整体样式*!*/
/*  width: 10px;     !*高宽分别对应横竖滚动条的尺寸*!*/
/*  height: 1px;*/
/*}*/
/*div::-webkit-scrollbar-thumb {!*滚动条里面小方块*!*/
/*  border-radius: 10px;*/
/*  -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);*/
/*  background: #ccd9f9;*/
/*}*/
/*div::-webkit-scrollbar-track {!*滚动条里面轨道*!*/
/*  -webkit-box-shadow: inset 0 0 5px rgba(0,0,0,0.2);*/
/*  border-radius: 10px;*/
/*  background: #EDEDED;*/
/*}*/
::-webkit-scrollbar {
  width: 0 !important;
}
::-webkit-scrollbar {
  width: 0 !important;height: 0;
}

</style>
