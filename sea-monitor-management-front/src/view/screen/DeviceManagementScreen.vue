<template>
    <div class="main">
        <div class="left">
            <div style="width: 11.5vw; height: 3vh;margin-left: 1vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);">
                &nbsp;
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span>&nbsp;&nbsp;&nbsp;设备列表</span>
            </div>
            <button v-for="(item) in deviceList" :key="item.name" class="left__button" @click="buttonClick(item.id)" :style="buttonIndex==item.id?{backgroundColor:'#2888E3'}:{}" >{{item.name}}</button>
            <button class="left__button--add" @click="buttonAdd">添加新设备</button>
        </div>
        <div class="right">
            <div style="width: 11.5vw; height: 3vh;margin-left: 1vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);">
                &nbsp;
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span v-if="deviceList[buttonIndex-1]">&nbsp;&nbsp;&nbsp;{{ deviceList[buttonIndex-1].name }}</span>
            </div>
            <button style="position: absolute;width: 6.25vw;height: 3.4vh;background: #009BE3;border-radius: 0.3vw;top: 3vh;right: 2vw;color: #fff;font-size: 0.8vwx;" @click="buttonSave">保存</button>
            <div class="materials-box" v-for="(item) in materialsList" :key="item.name">
                <span>{{item.name}}</span>
                <div class="materials-box__form">
                    <div>
                        <span>材料名称:</span>
                        <input type="text" placeholder="请输入材料名称" v-model="item.name">
                    </div>
                    <div>
                        <span>采样间隔:</span> 
                        <select name="请选择" id="" v-model="item.sample">
                            <option value="" selected hidden style="color:rgb(118, 118, 118);">请选择采样间隔</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                        </select>
                    </div>
                    <div>
                        <span>数据位:&emsp;</span>
                        <input type="text" style="width: 4vw;" v-model="item.bits">
                        <span>位 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 停止数:&nbsp;</span>
                        <input type="text" style="width: 4vw;" v-model="item.stopping">
                        <span>个</span>
                    </div>
                    <div>
                        <span>波特率:&emsp;</span>
                        <input type="text" v-model="item.baudRate">
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name:'DeviceManagementScreen',
        data(){
            return{
                buttonIndex:1,
                deviceList:[],
                materialsList:[],
                form:{}
            }
        },
        methods:{
            getData(){
                this.$http({
                    method:'get',
                    url:'chscent/device/getDataList'
                }).then(({data: res}) =>{
                    this.deviceList=res.data
                    // console.log(this.cameraData)
                })
                this.buttonClick(1);
            },
            buttonClick(a){
                this.buttonIndex=a
                this.$http({
                    method:'get',
                    url:'chscent/device/getMaterials',
                    params:{
                        id:this.buttonIndex
                    }
                }).then(({data: res}) =>{
                    this.materialsList=res.data
                    // this.deviceList=res.data
                    // console.log(this.cameraData)
                })
            },
            buttonSave(){
                console.log(this.materialsList)
                this.$http({
                    method:'put',
                    url:'chscent/device/update',
                    data:this.materialsList
                }).then(({data: res}) =>{
                    console.log(res.msg)
                    // this.materialsList=res.data
                    // this.deviceList=res.data
                    // console.log(this.cameraData)
                })
            },
            buttonAdd(){
                this.$http({
                    method:'Post',
                    url:'chscent/device/add',
                }).then(({data: res}) =>{
                    console.log(res.status)
                    // this.deviceList=res.data
                    // console.log(this.cameraData)
                })
                location.reload();
            }
        },
        mounted(){
            this.getData();
        }
        
    }
</script>

<style lang="less" scoped>
.main{
    width: 100%;
    height: 90%;
    
}
.left{
    width: 20.9vw;
    background-image: url(../../assets/screenImg/device-manage/left_bg.png);
    background-size: 100% 100%;
}
.right{
    width: 74.5vw;
    background-image: url(../../assets/screenImg/device-manage/right_bg.png);
    background-size: 100% 100%;
    position: relative;
}
.main>div{
    height: 86.4vh;
    float: left;
    margin-left: 1.5vw;
    margin-top: 2vh;
}
img{
    width: 2vw;
    height: 2vh;
}
img+span{
    color: #02A6E5;
    font-size: 1vw;
    position: relative;
    top: -0.3vh;
}
.left__button{
    width: 17.7vw;
    height: 4.6vh;
    margin-top: 2vh;
    margin-left: 1vw;
    background: rgba(0,155,227,0.2);
    color: #fff;
    font-size: 1vw;
    border-radius: 0.4vh;
    border: 0.2vh solid #009BE3;
}
.left__button--add{
    width: 17.7vw;
    height: 4.6vh;
    margin-top: 2vh;
    margin-left: 1vw;
    color: #fff;
    font-size: 1vw;
    border-radius: 0.4vh;
    background: #009BE3;
}
.materials-box{
    width: 22.8vw;
    height: 27vh;
    float: left;
    color: #fff;
    font-size: 0.9vw;
    margin-left: 1.5vw;
    margin-top: 2vh;
}
.materials-box__form{
    margin-top: 1vh;
    width: 22.8vw;
    height: 23.3vh;
    border-radius: 0.2vw;
    border: 0.1vh solid #009BE3;
}
.materials-box__form>div>span{
    font-size: 0.73vw;
}
.materials-box__form>div{
    margin-left: 1.5vw;
    margin-top: 2vh;
}
.materials-box__form input{
    height: 3vh;
    background-color: #D8D8D8;
    text-align: center;
    width: 15.8vw;
    font-size: 0.8vw;
    border-radius: 0.2vw;
    box-shadow: inset 3px 4px 3px 0px rgba(255,255,255,0.5);

}
.materials-box__form select{
    height: 3.1vh;
    background-color: #D8D8D8;
    text-align: center;
    width: 16.2vw;
    font-size: 0.8vw;
}
</style>