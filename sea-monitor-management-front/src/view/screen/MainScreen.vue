<template>
    <div class="screen_container">
        <div class="header">
            <span class="title">海洋新材料数据实时监测系统</span>
            <button class="button--main" @click="buttonClick(1)"
                :class="buttonIndex == 1 ? 'button--after' : ''">首页</button>
            <button class="button--basic" @click="buttonClick(2)"
                :class="buttonIndex == 2 ? 'button--after' : ''">基础配置</button>
            <button class="button--user" @click="buttonClick(3)"
                :class="buttonIndex == 3 ? 'button--after' : ''">用户管理</button>
            <button class="button--device" @click="buttonClick(4)"
                :class="buttonIndex == 4 ? 'button--after' : ''">设备管理</button>
            <button class="button--analysis" @click="buttonClick(5)"
                :class="buttonIndex == 5 ? 'button--after' : ''">实时数据</button>
            <button class="button--analysis2" @click="buttonClick(6)"
                :class="buttonIndex == 6 ? 'button--after' : ''">统计分析</button>

        </div>
        <!-- <div class="main"> -->
        <router-view />
        <!-- </div> -->
    </div>
</template>

<script>
export default {
    name: 'MainScreen',
    data() {
        return {
            buttonIndex: 1,
            cameraData: {
                temperature: '',
                humidness: '',
                electricity: '',
                voltage: '',
                resistance: '',
            },
            MonitoringData: {
                camera: '',
                sensor1: '',
                sensor2: '',
                reserved: '',
                multiple: ''
            }
        }
    },
    methods: {
        getConnect() {
            var sseSource = new EventSource("http://localhost:8888/sse/connect?name=main");
            sseSource.onmessage = (event) => {
                if (JSON.parse(event.data).temperature != null) {
                    this.cameraData = JSON.parse(event.data)
                }
                if (JSON.parse(event.data).camera != null) {
                    this.MonitoringData = JSON.parse(event.data)
                }
            }
        },
        buttonClick(a) {
            this.buttonIndex = a
            if (a == 1) {
                this.$router.push("/")
            }
            if (a == 4) {
                this.$router.push("/DeviceManagementScreen")
            }
            if (a == 5) {
                this.$router.push("/DeviceDetailsScreen")
            }
        },
        // Refresh() {
        // this.$router.go(0);
        // },
    },
    mounted() {
        this.getConnect()
        // window.addEventListener("resize", () => this.Refresh());
    }
}
</script>

<style lang="less" scoped>
.screen_container {
    background-image: url('../../assets/screenImg/screen_bg.png');
    background-repeat: no-repeat;
    background-size: cover;
    height: 100vh;
    width: 100vw;
    position: relative;
    // /*margin-top: -8px;
    // margin-left: -8px;
}

.header {
    background-image: url("../../assets/screenImg/screenHeader.png");
    background-repeat: no-repeat;
    background-size: 100% 160%;
    height: 10vh;
    width: 100vw;
    text-align: center;
    position: relative;
}

.title {
    font-size: 2vw;
    font-weight: normal;
    line-height: 11vh;
    text-shadow: 0px 0px 0.1rem #fafbfb, 0px 0px 0px #98D2FF;
    -webkit-background-clip: text;
    -webkit-text-fill-color: transparent;
}

button {
    font-size: 0.9vw;
    font-weight: 400;
    border-style: none;
    color: #FFFFFF;
    background-color: rgba(0, 0, 0, 0);
    background-image: url('../../assets/screenImg/buttonBefore.png');
    background-size: 100% 100%;
}

.button--main {
    position: absolute;
    left: 3vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--basic {
    position: absolute;
    left: 11.5vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--user {
    position: absolute;
    left: 20vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--device {
    position: absolute;
    left: 73vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--analysis {
    position: absolute;
    left: 82vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--analysis2 {
    position: absolute;
    left: 91vw;
    top: 5.5vh;
    width: 7.9vw;
    height: 3vh;
}

.button--after {
    background-image: url('../../assets/screenImg/buttonAfter.png');
}
</style>
