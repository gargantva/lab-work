<template>
    <div class="main">
        <div style="height: 5.6vh;width: 100%;overflow:hidden">
            <div style="float: left;margin-left:2.8vw;margin-top: 1.5vh ;" @click="goMain">
                <img src="../../assets/screenImg/deivce-details/left.png" alt="" style="width: 1.3vw;height: 1.3vw;">
                <span style="color: aliceblue;position: relative;top: -0.5vh;font-size: 0.7vw;">返回</span>
            </div>
            <div class="title"><span
                    style="color: #009BE3;font-size: 1.4vw;position: relative;top: -1.5vh;">设备名称实时数据</span></div>
        </div>
        <div :style="{ backgroundImage: 'url(' + require('../../assets/screenImg/deivce-details/data_bg.png') + ')' }"
            style="width: 93.75vw;height: 76.5vh;background-size: 100% 100%;margin-left:2.3vw ;">
            <div style="width: 36vw;height: 26vh;float: left;margin-left: 4vw;margin-top: 6vh;">
                <div><img src="../../assets/screenImg/deivce-details/button-camera.png" alt=""
                        style="width: 11.5vw;height: 3vh;"></div>
                <div
                    style="width: 7.2vw;height: 7.2vw;border: 0.2vw solid #FAAD14;border-radius: 50%;margin-top:3vh;float: left;">
                    <p style="display: flex;align-items:baseline;justify-content: center;margin-top: 2.5vh;"><span
                            style="font-size: 2.4vw;color: #FAAD14;">{{ this.$parent.cameraData.temperature
                            }}</span><span style="font-size: 1vw;color: #fff;">°C</span></p>
                    <p style="text-align: center;font-size: 1vw;color:#fff;margin-top: 1vh;">温度</p>
                </div>
                <div
                    style="width: 7.3vw;height: 7.3vw;border: 0.2vw solid #40A9FF;border-radius: 50%;float: left;margin-top:3vh;margin-left: 2vw;">
                    <p style="display: flex;align-items:baseline;justify-content: center;margin-top: 2.5vh;"><span
                            style="font-size: 2.4vw;color: #40A9FF;">{{ this.$parent.cameraData.humidness }}</span><span
                            style="font-size: 1vw;color: #fff;">%</span></p>
                    <p style="text-align: center;font-size: 1vw;color:#fff;margin-top: 1vh;">湿度</p>
                </div>
            </div>
            <div style="width: 42vw;height: 65.8vh;float: left;margin-left: 7.3vw;margin-top: 6vh;">
                <div><img src="../../assets/screenImg/deivce-details/button-data.png" alt=""
                        style="width: 11.5vw;height: 3vh;float: left;"></div>
                <div
                    style="float: left;width: 30vw;height: 65vh; display:flex;flex-direction:row;flex-wrap:wrap;gap: 1vh 1vw;">
                    <div class="box">
                        <p style="color: #fff;font-size: 1vw;margin-top: 1vh;margin-bottom: 1vh;">1组#1路</p>
                        <span style="color: #fff;float: left;margin-left: 0.8vw;margin-top: 1vh;">电压</span>
                        <div
                            style="width: 5vw;height: 2.4vh;background-color:#1B3067 ;float: left;margin-left: 1vw;margin-top: 1vh;">
                            <span style="color:#00EEDA ;">{{ this.$parent.MonitoringData.camera }}V</span>
                        </div>
                    </div>
                    <div class="box">
                        <p style="color: #fff;font-size: 1vw;margin-top: 1vh;margin-bottom: 1vh;">1组#2路</p>
                        <span style="color: #fff;float: left;margin-left: 0.8vw;margin-top: 1vh;">电压</span>
                        <div
                            style="width: 5vw;height: 2.4vh;background-color:#1B3067 ;float: left;margin-left: 1vw;margin-top: 1vh;">
                            <span style="color:#00EEDA ;">{{ this.$parent.MonitoringData.sensor1 }}V</span>
                        </div>
                    </div>
                    <div class="box">
                        <p style="color: #fff;font-size: 1vw;margin-top: 1vh;margin-bottom: 1vh;">1组#3路</p>
                        <span style="color: #fff;float: left;margin-left: 0.8vw;margin-top: 1vh;">电压</span>
                        <div
                            style="width: 5vw;height: 2.4vh;background-color:#1B3067 ;float: left;margin-left: 1vw;margin-top: 1vh;">
                            <span style="color:#00EEDA ;">{{ this.$parent.MonitoringData.sensor2 }}V</span>
                        </div>
                    </div>
                    <div class="box">
                        <p style="color: #fff;font-size: 1vw;margin-top: 1vh;margin-bottom: 1vh;">1组#4路</p>
                        <span style="color: #fff;float: left;margin-left: 0.8vw;margin-top: 1vh;">电压</span>
                        <div
                            style="width: 5vw;height: 2.4vh;background-color:#1B3067 ;float: left;margin-left: 1vw;margin-top: 1vh;">
                            <span style="color:#00EEDA ;">{{ this.$parent.MonitoringData.reserved }}V</span>
                        </div>
                    </div>
                    <div class="box">
                        <p style="color: #fff;font-size: 1vw;margin-top: 1vh;margin-bottom: 1vh;">1组#5路</p>
                        <span style="color: #fff;float: left;margin-left: 0.8vw;margin-top: 1vh;">电压</span>
                        <div
                            style="width: 5vw;height: 2.4vh;background-color:#1B3067 ;float: left;margin-left: 1vw;margin-top: 1vh;">
                            <span style="color:#00EEDA ;">{{ this.$parent.MonitoringData.multiple }}V</span>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'DeviceDetailsScreen',
    data() {
        return {
        }
    },
    methods: {
        goMain() {
            this.$router.push("/MainScreen")
        }
    }
}
</script>

<style lang="less" scoped>
.main {
    width: 98vw;
    height: 87vh;
    margin-left: 1vw;
    margin-top: 2vh;
    background-image: url(../../assets/screenImg/deivce-details/bg.png);
    background-size: 100% 100%;
}

.title {
    text-align: center;
    width: 38.8vw;
    height: 0.7vh;
    background-image: url(../../assets/screenImg/deivce-details/title.png);
    background-size: 100% 100%;
    margin: 2.5vh auto;
}

.box {
    width: 9.3vw;
    height: 12vh;
    background-image: url(../../assets/screenImg/deivce-details/small_bg.png);
    background-size: 100% 100%;
    text-align: center;
    overflow: auto;
    font-size: 0.7vw;
}
</style>