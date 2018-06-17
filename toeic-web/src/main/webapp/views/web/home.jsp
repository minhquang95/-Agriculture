<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<c:url value="CheckHumidity" var="Check"></c:url>
<c:url var="SendDataToESP" value="SendDataToESP">
    <c:param name="typeUrl" value="TatSensor"/>
</c:url>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><fmt:message key="label.home" bundle="${lang}"/></title>

    <script type = "text/javascript">

        var value = new Array();
        var flag = false;
        var eventSource = null;
        var myVar=setInterval(function(){myTimer()},1000);

        function myTimer() {
            var d=new Date();
            var t=d.toLocaleTimeString();
            document.getElementById("h").innerHTML=t;
            if(t.getHours == 0){
                CheckTime(1,t.getMinutes,t.getSeconds);
            }
//            else{
//                console.log("Hello");
//            }
            for (var i = 0 ; i<value.length; i++){
                if(t.getHours == value[i]){
                    CheckTime(2,t.getMinutes,t.getSeconds);
                }
            }
        }

        function CheckTime(check,minutes,second){
            if(minutes ==0 && second ==0){
                if(check ==1){
                    value = senddata('CheckHumidity','Check', 'Get');
                }
                if(check == 2){
                    senddata('SendDataToESP','Mo','Post');
                }

            }
        }

        function senddata(url,data,typeTran){
            var valueData = new Array();
            $.ajax({
                type: typeTran,
                url: url,
                data: {
                    value:data
                },
                success: function(response){
                    console.log(response);
                     var valueString = JSON.parse(response);
                     console.log(valueString);
                     if(valueString.ValueCheck == 2){
                         document.getElementById('result1').innerHTML = valueString.Stringvalue;
                     }
                     if(valueString.ValueCheck == 1){
                         console.log(valueString.ValueCheck);
                         console.log(valueString.Stringvalue[2]);
                         for(var i = 0 ; i<valueString.Stringvalue.length;i++){
                             valueData[i] = valueString.Stringvalue[i];
                         }
                     }
                },
                error: function(response){

                }
            });
            return valueData;
        }



        function start() {
            eventSource = new EventSource("SendDataToESP");
//            document.getElementById("bt1Off").disabled = false;
//            document.getElementById("bt1On").disabled = true;
            eventSource.addEventListener('sensorHumidity', function(event) {

                document.getElementById('text1').innerHTML = event.data;

            }, false);

            eventSource.addEventListener('sensorPH', function(event) {

                document.getElementById('text2').innerHTML = event.data;

            }, false);

            eventSource.addEventListener('sensorWaterFlow', function(event) {

                document.getElementById('text3').innerHTML = event.data;

            }, false);
            eventSource.addEventListener('stop', function(event) {
                eventSource.close();
                document.getElementById("bt1Off").disabled = event.data;
                document.getElementById("bt1On").disabled = !(event.data);
            }, false);
        }



        <c:if test="${sessionScope.user !=null}">

            if(sessionStorage.hits){
                sessionStorage.hits = Number(sessionStorage.hits) +1;
                senddata('SendDataToESP','LoadPage','Post');
                start();

            }else{
                sessionStorage.hits = 1;
                senddata('SendDataToESP','Page','Post');
                start();
             }
        </c:if>
        document.write("Total Hits :" + sessionStorage.hits );
    </script>

</head>
<body>
<div class="container">
        <div class="carousel-inner">

            <div class="active item">
                    <div class="row">
                        <div class="span6">
                            <div class="count-grid" margin: 10px;>
                                <h3 class="time">Đồng Hồ</h3>

                                <center>
                                    <div class="hours_text" id ="h">

                                    </div>
                                </center>
                                <div class="clearfix"> </div>
                            </div>

                        </div>


                        <div class="span6">
                            <div class="count-grid">
                                <h3 class="time">Thời Tiết</h3>
                                <div class="weather-forcast">
                                    <img src="/template/2.png" alt="Nhiệt Độ" class="mattroi">
                                    <p>Nhiệt Độ</p>
                                </div>
                                <div class="weather-value">
                                    <p id = "result1"></p>
                                </div>
                                <div class="weather-forcast">
                                    <img src="/template/doam.png" alt="Nhiệt Độ" class="mattroi">
                                    <p>Độ Ẩm</p>
                                </div>
                            </div>
                        </div>
                    </div>
                 </div>
            </div>
        <!-- /.Carousel nav -->
    <!-- /Carousel -->



    <!-- Feature
==============================================-->


    <div class="row feature-box">
        <div class="span12 cnt-title">
            <h1><fmt:message key="label.programOfSensor" bundle="${lang}"/></h1>
        </div>
        <div class="span4">
            <span id = "text3"></span>
            <h2><fmt:message key="label.sensorWater" bundle="${lang}"/></h2>
            <%--<button id="bt1Off" onclick="senddata('SendDataToESP','sensorWaterFlow')"><fmt:message key="label.off" bundle="${lang}"/></button>--%>
        </div>
        <div class="span4">
            <span id = "text2"></span>
            <h2><fmt:message key="label.sensorPH" bundle="${lang}"/></h2>
            <%--<button id="bt2Off" onclick="senddata('SendDataToESP','sensorPH')"><fmt:message key="label.off" bundle="${lang}"/></button>--%>
        </div>

        <div class="span4">
            <span id = "text1"></span>
            <h2><fmt:message key="label.sensorSoil" bundle="${lang}"/></h2>
            <%--<button id="bt3Off" onclick="senddata('SendDataToESP','sensorHumidity')"><fmt:message key="label.off" bundle="${lang}"/></button>--%>
        </div>
    </div>
    <%--<div class="on">--%>
    <%--<button id="bt1On" onclick="start()"><fmt:message key="label.on" bundle="${lang}"/></button>--%>
    <%--</div>--%>
    <%--</br>--%>
    <%--</br>--%>
    <%--</br>--%>
    <%--<div class="on">--%>
        <%--<form action="/SendDataToESP" method="post">--%>
        <%--<button id="bt1Off"  ><fmt:message key="label.off" bundle="${lang}"/></button>--%>
        <%--</form>--%>
    <%--</div>--%>

    <%--<div class="on">--%>
        <%--<button id="Test" onclick="senddata('SendDataToESP','Mo','Post')">Test</button>--%>
    <%--</div>--%>


</div>
</body>
</html>