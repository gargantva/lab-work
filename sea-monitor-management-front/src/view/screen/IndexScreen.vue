<template>
    <div class="main">
        <div class="a">
            <div style="width: 12.5vw; height: 3vh;margin-left: 1vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);"
                @click="goData">
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span>&nbsp;&nbsp;当前设备监测数据</span>
            </div>
            <p style="font-size: 0.7vw;color: #FFFFFF;margin-left: 2vw;margin-top: 0.5vh;margin-bottom: 0.8vh;">
                组&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;段落&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;电压
            </p>
            <table>
                <tr>
                    <td rowspan="5" class="bt0 table__first">第一组</td>
                    <td class="bt0">第一路</td>
                    <td class="bt0">{{ this.$parent.MonitoringData.camera }}V</td>
                </tr>
                <tr>
                    <td>第二路</td>
                    <td>{{ this.$parent.MonitoringData.sensor1 }}V</td>
                </tr>
                <tr>
                    <td>第三路</td>
                    <td>{{ this.$parent.MonitoringData.sensor2 }}V</td>
                </tr>
                <tr>
                    <td>第四路</td>
                    <td>{{ this.$parent.MonitoringData.reserved }}V</td>
                </tr>
                <tr>
                    <td>第五路</td>
                    <td>{{ this.$parent.MonitoringData.multiple }}V</td>
                </tr>
            </table>
        </div>
        <div class="b">
            <div class="map_container" ref="map" id="container"></div>
            <div class="b__device--bg" style="left:26vw;">
                <img src="../../assets/screenImg/device-number.png" alt=""
                    style="height:7.8vh;width:7.8vh;margin-left: 1vw;margin-top: 2.5vh;float: left;">
                <p style="float: left;color:#88C1FF;font-size: 1vw;margin-top: 0.5vh;margin-left: 1.5vw;"><span
                        style="font-size: 3vw;">{{ this.deviceData.count }}</span> <span style="color: #fff;">个</span>
                    <br>设备总数
                </p>
            </div>
            <div class="b__device--bg" style="left:43vw;">
                <img src="../../assets/screenImg/device-online.png" alt=""
                    style="height:7.8vh;width:7.8vh;margin-left: 1vw;margin-top: 2.5vh;float: left;">
                <p style="float: left;color:#88C1FF;font-size: 1vw;margin-top: 0.5vh;margin-left: 1.5vw;"><span
                        style="font-size: 3vw;color: #00EEDA;">{{ this.deviceData.online }}</span> <span
                        style="color: #fff;">个</span> <br>在线设备</p>
            </div>
            <div class="b__device--bg" style="left:60vw;">
                <img src="../../assets/screenImg/device-warning.png" alt=""
                    style="height:7.8vh;width:7.8vh;margin-left: 1vw;margin-top: 2.5vh;float: left;">
                <p style="float: left;color:#88C1FF;font-size: 1vw;margin-top: 0.5vh;margin-left: 1.5vw;"><span
                        style="font-size: 3vw;color: #D9363E;">{{ this.deviceData.warning }}</span> <span
                        style="color: #fff;">个</span> <br>预警设备</p>
            </div>
            <img src="../../assets/screenImg/b-view.png" alt=""
                style="position: absolute; width: 18.75vw;height: 24.5vh;left: 55vw;top:24vh;">
            <!-- <img src="../../assets/screenImg/circleIcon-big.png" alt="" style="position: absolute; width: 7.6vh;height: 7.6vh;left: 47vw;top:27vh;">
            <img src="../../assets/screenImg/circleIcon.png" alt="" style="position: absolute; width: 5.7vh;height: 5.7vh;left: 37vw;top:35vh;"> -->
        </div>
        <div class="c">
            <div
                style="width: 11vw; height: 3vh;margin-left: 1vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);">
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span>&nbsp;&nbsp;摄像头数据监测</span>
            </div>
            <div
                style="width: 7.3vw;height: 7.3vw;border: 0.2vw solid #FAAD14;border-radius: 50%;float: left;margin-top:3vh;margin-left: 2vw;">
                <p style="display: flex;align-items:baseline;justify-content: center;margin-top: 2.5vh;"><span
                        style="font-size: 2.4vw;color: #FAAD14;">{{ this.$parent.cameraData.temperature }}</span><span
                        style="font-size: 1vw;color: #fff;">°C</span></p>
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
        <div class="d">
            <div
                style="width: 12.5vw; height: 3vh;margin-left: 2vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);">
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span>&nbsp;&nbsp;设备状态</span>
            </div>
            <div id="d__echarts" style="width: 20.6vw;height: 24.1vh;">
            </div>
        </div>
        <div class="e">
            <div
                style="width: 16vw; height: 3vh;margin-left: 1.5vw;margin-top: 1vw;border-bottom: 0.15vw dashed rgb(237, 233, 233);">
                <img src="../../assets/screenImg/arrow.png" alt="">
                <span>&nbsp;&nbsp;近30天设备预警率,在线率</span>
            </div>
            <div id="e__echarts" style="width: 75vw;height: 28.1vh;margin-top: -2.2vw;">

            </div>
        </div>
    </div>
</template>

<script>
import { EleResize } from '../../assets/js/esresize.js'
import icon from '../../assets/screenImg/icon.png'
import circleIcon from '../../assets/screenImg/circleIcon-big.png'
export default {
    name: 'IndexScreen',
    data() {
        return {
            iconImg: icon,
            cirleIcon: circleIcon,
            deviceData: {},
            rate: {
                onlineRate: [],
                waringRate: [],
                time: []
            }
            // redCardShow:false,
            // yellowCardShow:false,
            // greenCardShow:false,
            // closeImge:close,
            // iconImg:icon,
            // river:"九曲河"
        }
    },
    mounted() {
        this.getConnect();
        this.loadmap();
        this.getDeviceData();
        // window.addEventListener("resize", () => this.Refresh());
    },
    methods: {
        getDeviceData() {
            this.$http({
                method: 'get',
                url: 'http://localhost:8888/device'
            })
        },
        getConnect() {
            var sseSource = new EventSource("http://localhost:8888/sse/connect?name=device");
            sseSource.onmessage = (event) => {
                if (JSON.parse(event.data).count != null) {
                    this.deviceData = JSON.parse(event.data)
                }
            }
        },
        loadPieEcharts() {
            let myChart = this.$echarts.init(document.getElementById('d__echarts'));
            let that = this;
            var initOption = function () {
                var m2R2Data = [
                    { value: that.deviceData[1], name: "正常", itemStyle: { color: "#009BE3" } },
                    { value: that.deviceData[2], name: "离线", itemStyle: { color: "#5D7092" } },
                    { value: that.deviceData[3], name: "预警", itemStyle: { color: "#FAAD14" } },
                    { value: that.deviceData[4], name: "报警", itemStyle: { color: "#E8684A" } },
                ];
                var option = {
                    legend: {
                        type: "scroll",
                        orient: 'vertical',
                        x: '76%',
                        align: 'left',
                        y: '25%',
                        itemHeight: that.myEchartsFontSize(13),
                        itemWidth: that.myEchartsFontSize(16),
                        itemGap: that.myEchartsFontSize(6),
                        textStyle: {
                            fontSize: that.myEchartsFontSize(14) + 'px',
                            color: '#fff',
                        },
                        icon: 'circle',
                        height: that.myEchartsFontSize(250)
                    },
                    series: [
                        {
                            type: 'pie',
                            center: ['40%', '45%'],
                            radius: ['40%', '65%'],
                            clockwise: true, //饼图的扇区是否是顺时针排布
                            avoidLabelOverlap: false,
                            label: {
                                show: true,
                                formatter: function (parms) {
                                    return parms.data.value
                                },

                                fontSize: that.myEchartsFontSize(13) + 'px',
                                color: '#B0CEFC'

                            },
                            labelLine: {
                                length: that.myEchartsFontSize(20),
                                length2: that.myEchartsFontSize(15),
                                lineStyle: {
                                    width: that.myEchartsFontSize(1),
                                }
                            },
                            data: m2R2Data
                        }
                    ]
                };
                myChart.setOption(option);
            }
            initOption();
            //使用监听器监听页面变化，需要使用removeEve。。方法删除监听器
            // let sizeFun = function () {
            //     myChart.resize()
            //     console.log(1111);
            // }
            // window.addEventListener('resize', sizeFun )
            //在div上实现类似window的onresize 监听，这样既能实现图表的自适应，也不会因为页面跳转之后继续执行三个页面的onresize 方法
            let resizeDiv = document.getElementById('d__echarts')
            let listener = function () {
                myChart.resize();
                initOption();
            }
            EleResize.on(resizeDiv, listener)
        },
        loadLineEcharts() {
            let myChart = this.$echarts.init(document.getElementById('e__echarts'));
            let that = this;
            var initOption = function () {
                //数据
                var XName = that.rate.time
                var data1 = [
                    that.rate.waringRate,
                    that.rate.onlineRate,
                ]
                var Line = ["预警率", "在线率"];
                var color = ['#D9363E', '#009BE3'];
                //数据处理
                var datas = [];
                Line.map((item, index) => {
                    datas.push(
                        {
                            symbolSize: that.myEchartsFontSize(8),
                            symbol: 'emptyCircle',
                            name: item,
                            type: "line",
                            yAxisIndex: 1,
                            data: data1[index],
                            itemStyle: {

                                borderWidth: 5,
                                color: color[index],

                            },
                            lineStyle: {

                                width: that.myEchartsFontSize(2),

                            }
                        }
                    )
                })
                var option = {
                    grid: {
                        left: '6%',
                        top: '20%',
                        bottom: '10%',
                        right: '2%',
                    },
                    tooltip: {
                        trigger: 'axis',
                        backgroundColor: '#fff',
                        textStyle: {
                            color: '#5c6c7c'
                        },
                    },
                    legend:
                    {
                        type: "scroll",
                        x: '87%',
                        y: '5%',
                        data: Line,
                        itemWidth: that.myEchartsFontSize(25),
                        itemHeight: that.myEchartsFontSize(10),
                        textStyle: {
                            fontSize: that.myEchartsFontSize(14)
                        },
                        data: [
                            {
                                name: '预警率',
                                textStyle: {
                                    color: "#D9363E",
                                },
                            },
                            {
                                name: '在线率',
                                textStyle: {
                                    color: "#009BE3",
                                },
                            }
                        ]
                    },
                    yAxis: [
                        {
                            type: 'value',
                            position: 'left',
                            splitLine: {
                                show: false
                            },
                            axisLine: {
                                show: true,
                                lineStyle: {
                                    color: '#fff',
                                    width: that.myEchartsFontSize(1),
                                }
                            },
                            axisTick: {
                                show: false
                            },
                            axisLabel: {
                                show: false
                            }
                        },
                        {
                            type: 'value',
                            position: 'left',
                            nameTextStyle: {
                                color: '#00FFFF'
                            },
                            splitLine: {
                                lineStyle: {
                                    type: 'dashed',
                                    color: 'rgba(135,140,147,0.8)',
                                    width: that.myEchartsFontSize(1),
                                }
                            },
                            axisLine: {
                                show: false
                            },
                            axisTick: {
                                show: false
                            },
                            axisLabel: {
                                formatter: '{value}%',
                                color: '#fff',
                                fontSize: that.myEchartsFontSize(14),
                                margin: that.myEchartsFontSize(10),
                            }
                        },
                    ],
                    xAxis: {
                        type: 'category',
                        axisTick: {
                            show: false
                        },
                        axisLine: {
                            show: true,
                            lineStyle: {
                                color: '#fff',
                                width: that.myEchartsFontSize(1),
                            }
                        },
                        axisLabel: {
                            inside: false,

                            color: '#fff',// x轴颜色
                            fontWeight: 'normal',
                            fontSize: that.myEchartsFontSize(15),
                            lineHeight: that.myEchartsFontSize(22),

                            margin: that.myEchartsFontSize(5),
                        },
                        data: XName,
                    },
                    series: datas,
                };
                myChart.setOption(option)
            }
            initOption();
            let resizeDiv = document.getElementById('e__echarts')
            let listener = function () {
                myChart.resize();
                initOption();
            }
            EleResize.on(resizeDiv, listener)
        },
        //自适应
        myEchartsFontSize(value) {
            let screenWidth = document.body.clientWidth;
            const result = value * (screenWidth / 1920);
            return result;
        },
        loadmap() {
            const that = this
            const map = new AMap.Map('container', {
                zoom: 13,
                center: [122.13965339, 29.83540047],
                zooms: [12, 18]
            });
            const path = [
                //每个弧线段有两种描述方式
                [121.579114, 29.86585], //起点
                [121.654301, 29.849856], [121.670016, 29.846261],
            ];

            var bezierCurve = new AMap.BezierCurve({
                path: path,
                map,
                strokeColor: "#D9363E",
                strokeWeight: 5,
                strokeOpacity: 1
            });
            const pathGreen = [
                //每个弧线段有两种描述方式
                [121.605879, 29.860228], //起点
                [121.608076, 29.86835, 121.608385, 29.871373],
                [121.609103, 29.873001, 121.610202, 29.874134, 121.612513, 29.875843],
                [121.615298, 29.877781, 121.623352, 29.882481, 121.626027, 29.883403],
                [121.628001, 29.883078], [121.62901, 29.885303, 121.634773, 29.88592, 121.6361, 29.886377],
                [121.637045, 29.887646, 121.637459, 29.888548], [121.637706, 29.893622, 121.637936, 29.894514]
            ];

            var bezierCurveGreen = new AMap.BezierCurve({
                path: pathGreen,
                map,
                strokeColor: "#52C41A",
                strokeWeight: 5,
                strokeOpacity: 1
            });
            const pathYellow = [
                //每个弧线段有两种描述方式
                [121.602933, 29.848491], //起点
                [121.60196, 29.846766, 121.601418, 29.845435, 121.600927, 29.844089], [121.60062, 29.84329, 121.600574, 29.841851, 121.600687, 29.840397],
                [121.600889, 29.839493], [121.600623, 29.837655, 121.600301, 29.836072],
                [121.59956, 29.833628, 121.59893, 29.830827, 121.598647, 29.829533], [121.592863, 29.8169],
                [121.59018, 29.812524, 121.588671, 29.809949, 121.587354, 29.808528], [121.575481, 29.795962],
            ];

            var bezierCurveYellow = new AMap.BezierCurve({
                path: pathYellow,
                map,
                strokeColor: "#FAAD14",
                strokeColor: "#FAAD14",
                strokeWeight: 5,
                strokeOpacity: 1
            });
            // 创建一个 icon
            var redIcon = new AMap.Icon({
                size: new AMap.Size(30, 40),
                image: this.iconImg,
                imageSize: new AMap.Size(27, 26),
                imageOffset: new AMap.Pixel(0, 13)
            });
            //创建一个Circleicon
            var CircleIcon = new AMap.Icon({
                size: new AMap.Size(50, 50),
                image: this.cirleIcon,
                imageSize: new AMap.Size(50, 50),
                imageOffset: new AMap.Pixel(0, 0)
            });
            // 将 Circleicon 传入 marker
            var circleMarker = new AMap.Marker({
                position: new AMap.LngLat(122.1326, 29.8455),
                icon: CircleIcon,
                offset: new AMap.Pixel(0, 0)
            });
            var CircleIcon2 = new AMap.Icon({
                size: new AMap.Size(70, 70),
                image: this.cirleIcon,
                imageSize: new AMap.Size(70, 70),
                imageOffset: new AMap.Pixel(0, 0)
            });
            // 将 Circleicon 传入 marker
            var circleMarker2 = new AMap.Marker({
                position: new AMap.LngLat(122.0837, 29.8281),
                icon: CircleIcon2,
                offset: new AMap.Pixel(0, 0)
            });
            // 将 icon 传入 marker
            var redMarker = new AMap.Marker({
                position: new AMap.LngLat(121.654301, 29.849856),
                icon: redIcon,
                offset: new AMap.Pixel(-13, -30)
            });
            // 创建一个 icon
            var yellowIcon = new AMap.Icon({
                size: new AMap.Size(30, 40),
                image: this.iconImg,
                imageSize: new AMap.Size(27, 26),
                imageOffset: new AMap.Pixel(0, 13)
            });

            // 将 icon 传入 marker
            var yellowMarker = new AMap.Marker({
                position: new AMap.LngLat(121.59018, 29.812524),
                icon: yellowIcon,
                offset: new AMap.Pixel(-13, -30)
            });
            // 创建一个 icon
            var greenIcon = new AMap.Icon({
                size: new AMap.Size(30, 40),
                image: this.iconImg,
                imageSize: new AMap.Size(27, 26),
                imageOffset: new AMap.Pixel(0, 13)
            });

            // 将 icon 传入 marker
            var greenMarker = new AMap.Marker({
                position: new AMap.LngLat(121.628001, 29.883078),
                icon: greenIcon,
                offset: new AMap.Pixel(-13, -30)
            });
            greenMarker.on("click", that.showGreenCard)
            yellowMarker.on("click", that.showYellowCard)
            redMarker.on("click", that.showRedCard)
            // 将 markers 添加到地图
            map.add([greenMarker, yellowMarker, redMarker, circleMarker, circleMarker2]);
            map.setFeatures(['point', 'bg', 'building'])
            AMapUI.load(['ui/geo/DistrictExplorer', 'lib/$'], function (DistrictExplorer, $) {

                //创建一个实例
                var districtExplorer = window.districtExplorer = new DistrictExplorer({
                    eventSupport: true, //打开事件支持
                    map: map
                });
                var count = 1095;
                var _renderClusterMarker = function (context) {
                    // console.log(context.count);
                    // var factor = Math.pow(context.count / count, 1 / 18);
                    var div = document.createElement('div');
                    var Hue = 120;
                    try {
                        for (var i = 0; i < context.clusterData.length; ++i) {
                            if (context.clusterData[i].status == 2)
                                Hue = 60;
                            if (context.clusterData[i].status == 1) { Hue = 0; break; }
                        }
                    }
                    catch (err) {
                        console.error(err)
                    }
                    var bgColor = 'hsla(' + Hue + ',100%,40%,0.7)';
                    var fontColor = 'hsla(' + Hue + ',100%,90%,1)';
                    var borderColor = 'hsla(' + Hue + ',100%,40%,1)';
                    var shadowColor = 'hsla(' + Hue + ',100%,90%,1)';
                    div.style.backgroundColor = bgColor;
                    var size = Math.round(30 + Math.pow(context.count / count, 1 / 5) * 20);
                    div.style.width = div.style.height = size + 'px';
                    div.style.border = 'solid 1px ' + borderColor;
                    div.style.borderRadius = size / 2 + 'px';
                    div.style.boxShadow = '0 0 5px ' + shadowColor;
                    div.innerHTML = context.count;
                    div.style.lineHeight = size + 'px';
                    div.style.color = fontColor;
                    div.style.fontSize = '14px';
                    div.style.textAlign = 'center';
                    context.marker.setOffset(new AMap.Pixel(-size / 2, -size / 2));
                    context.marker.setContent(div)
                }
                var _renderMarker = function (context) {
                    // console.log(context);
                    // var content = '<img src="require(\'@/assets/images/base-station.png\')" style="height: 18px; width: 18px;
                    // border: 1px solid hsl(180, 100%, 40%); border-radius: 12px; box-shadow: hsl(180, 100%, 50%) 0px 0px 3px;">';
                    var div = document.createElement('div');
                    var Hue = 120;
                    // for(var i=0;i<context.count;++i){
                    //   div.innerHTML = context.data[i].gatewayId;
                    //   if(context.data[i].status==1)
                    //   { div.style.backgroundImage='url(' + that.bg2 + ')';break;}
                    //   if(context.data[i].status==2)
                    //   { div.style.backgroundImage='url(' + that.bg3 + ')';break;}
                    //   div.style.backgroundImage='url(' + that.bg1 + ')';
                    // }
                    var bgColor = 'hsla(' + Hue + ',100%,40%,0.7)';
                    var fontColor = 'hsla(' + Hue + ',100%,90%,1)';
                    var borderColor = 'hsla(' + Hue + ',100%,40%,1)';
                    var shadowColor = 'hsla(' + Hue + ',100%,90%,1)';
                    // div.style.backgroundColor = bgColor;
                    div.style.width = '40px';
                    div.style.height = '60px';
                    div.style.backgroundSize = "100% 100%"
                    div.style.backgroundRepeat = 'no-repeat';
                    // div.style.border = 'solid 1px ' + borderColor;
                    // div.style.borderRadius ='12px';
                    // div.style.boxShadow = '0 0 3px ' + shadowColor;
                    // div.innerHTML = context.data;
                    div.style.lineHeight = '45px';
                    div.style.color = fontColor;
                    div.style.fontSize = '20px';
                    div.style.textAlign = 'center';
                    var offset = new AMap.Pixel(-9, -9);
                    context.marker.setContent(div)
                    context.marker.setOffset(offset)
                }
                map.plugin(['AMap.MarkerClusterer'], function () {
                    that.cluster = new AMap.MarkerClusterer(
                        map, // 地图实例
                        that.markData, // 海量点组成的数组
                        {
                            gridSize: 30,
                            maxZoom: 13,
                            zIndex: 2,
                            zoomOnClick: false,
                            renderClusterMarker: _renderClusterMarker,
                            renderMarker: _renderMarker, // 自定义非聚合点样式
                        })
                })
                // //这句是重点，当点击的时候
                that.cluster.on("click", (cluster) => {
                    // console.log(cluster.clusterData);

                    if (cluster.clusterData.length > 1)
                        map.setZoomAndCenter(14, cluster.clusterData[0].lnglat);
                    else {
                    }

                    // var data=[];
                    // for (var i = 0; i <cluster.clusterData.length; i++) {
                    //   var oneData={};//
                    //   oneData.houseNo=cluster.clusterData[i].houseNo;
                    //   oneData.address=cluster.clusterData[i].address;
                    //   oneData.houseCondition=cluster.clusterData[i].houseCondition;
                    //   data.push(oneData);
                    // }
                    // that.tableData=data;
                })



                //定位点Marker
                var locMarker = new AMap.Marker();

                function listenMouseEvents() {

                    // var isLocating = false;

                    map.on('click', function (e) {
                        // console.log(e.lnglat);
                        //   var q = e.lnglat.getLng();
                        //   var w = e.lnglat.getLat();
                        //   console.log(q)
                        //   console.log(w)
                        //   var qe = event || window.event;
                        //   var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
                        //   var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
                        //   var x = qe.pageX || qe.clientX + scrollX;
                        //   var y = qe.pageY || qe.clientY + scrollY;
                        //   alert(x+","+y); //相对于浏览器
                        //   e.pixel.x=x;
                        //   e.pixel.y=y;
                        //   console.log(e)
                        // mapObj.clearMap();

                        if (that.isLocating) {
                            // console.log(that.isLocating);
                            locMarker.destroy();
                            that.addLocation = '';
                            return;
                        }

                        that.isLocating = true;

                        // console.log("定位中");

                        districtExplorer.locatePosition(e.lnglat, function (err, features) {

                            that.isLocating = false;

                            if (err) {
                                console.error(err);
                                return;
                            }
                            // console.log(e.lnglat);
                            // console.log(features);
                            //
                            // refreshLocTip(e.lnglat, features);
                            that.addLocation = e.lnglat;
                            locMarker.setPosition(e.lnglat);

                            locMarker.setMap(map);
                        }, {
                            levelLimit: 4
                        });

                    });
                }

                listenMouseEvents();
                $(".river").bind("click", function () {
                    if (that.river == '九曲河')
                        map.setZoomAndCenter(15, [121.654301, 29.849856]);
                    if (that.river == '新杨木碶河')
                        map.setZoomAndCenter(15, [121.59018, 29.812524]);
                    if (that.river == '甬新河')
                        map.setZoomAndCenter(15, [121.628001, 29.883078]);
                })
            });
        },
        goData() {
            this.$router.push("/MainScreen/DeviceDetailsScreen")
        },
        getData() {
            this.$http({
                method: 'get',
                url: 'chscent/device/getDeviceState'
            }).then(({ data: res }) => {
                this.deviceData = res.data
                // console.log(this.deviceData)
                this.deviceData.push(this.deviceData[0] - this.deviceData[1] - this.deviceData[2] - this.deviceData[3])
                this.loadPieEcharts();
            })
            this.$http({
                method: 'get',
                url: 'chscent/device/getRate'
            }).then(({ data: res }) => {
                res.data.forEach(element => {
                    this.rate.onlineRate.push(element.onlineRate)
                    this.rate.waringRate.push(element.warningRate)
                    var date = new Date(Date.parse(element.time))
                    this.rate.time.push(date.getMonth() + '-' + date.getDate())

                });
                this.loadLineEcharts();
                console.log(this.rate)
            })
        }
    },
}
</script>

<style lang="less" scoped>
.main {
    padding: 1.51vw;
    height: 83vh;
    display: grid;
    grid-gap: 1.51vw;
    grid-template-columns: 21vw 52.5vw 21vw;
    grid-template-rows: 54vh 29vh;
    position: relative;
}

.a {
    background-image: url(../../assets/screenImg/deviceData_bg.png);
    background-size: 100% 100%;
    grid-column: 1;
    grid-row: 1;
}

.b {
    grid-column: 2;
    grid-row: 1;
}

.c {
    background-image: url(../../assets/screenImg/deviceData_bg.png);
    background-size: 100% 100%;
    grid-column: 3;
    grid-row: 1;
}

.d {
    background-image: url(../../assets/screenImg/deviceState_bg.png);
    background-size: 100% 100%;
    grid-column: 1;
    grid-row: 2;
}

.e {
    background-image: url(../../assets/screenImg/deviceChart-bg.png);
    background-size: 100% 100%;
    grid-column: 2 / 4;
    grid-row: 2;
}

img {
    width: 2vw;
    height: 2vh;
}

span {
    font-size: 1vw;
    color: #02A6E5;
    vertical-align: text-bottom;
}

table {
    width: 18.7vw;
    height: 13.9vh;
    margin-left: 1vw;
    margin-bottom: 1vh;
    border: 0.05vw solid #009be3;
    border-radius: 0.5vw;
    border-collapse: separate;
    border-spacing: 0;
    color: #FFFFFF;
    font-size: 0.7vw;
}

td {
    text-align: center;
    border: 0.01vw solid #009be3;
    border-width: 0.1vh 0.1vh 0px 0px;
}

td:last-child {
    border-right: 0px;
}

.bt0 {
    border-top: 0px;
}

.table__first {
    width: 2.5vw;
    Writing-mode: tb-rl;
    background: rgba(26, 193, 247, 0.3);
}

tr:nth-child(2) td:first-child {
    width: 4vw;
}

.c__rectangle {
    width: 17.8vw;
    height: 8.1vh;
    background-image: url(../../assets/screenImg/data_bg.png);
    background-size: 100% 100%;
    margin: 1.2vh 0 0 1.6vw;
    float: left;
    line-height: 4vh;
}

.b__device--bg {
    width: 14.7vw;
    height: 13.1vh;
    background-image: url(../../assets/screenImg/b-device_bg.png);
    background-size: 100% 100%;
    position: absolute;
    top: 7vh;
}
</style>
