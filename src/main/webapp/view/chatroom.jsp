<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ChatRoom</title>
    <script type="application/javascript">
        let server;
        send = function (text) {
            if (server != null) {
                server.send(text);
            } else {
                appendText("failure send");
            }
        }
        sendMsg = function () {
            let text = document.getElementById("msg").value;
            send(text);
        }
        closeServer = function () {
            server?.close();
        }
        appendText = function (text) {
            document.getElementById("content").innerHTML = document.getElementById("content").innerHTML + "<p>" + text+ "</p>";
        }

        createLink = function () {
            try {
                closeServer();
                server = new WebSocket('ws://' + window.location.host +
                    '/chatroom/${roomId}');
            } catch (error) {
            }
            //WebSocket的onopen
            server.onopen = function () {
                appendText('WebSocket OnOpen');
            };


            //WebSocket的onclose
            server.onclose = function (event) {
                if (!event.wasClean || event.code !== 1000) {
                    appendText('WebSocket error' + event.code + ',reason,' + event.reason);
                } else {
                    appendText('WebSocket shutdown');
                }
            };

            //WebSocket的onerror
            server.onerror = function (event) {
                appendText('WebSocket error： ' + event.data);
            };

            //WebSocket的onmessage
            server.onmessage = function (event) {
                var message = event.data;
                appendText(message);
            };
        }

    </script>
</head>
<body>
<input name="msg" type="text" id="msg"/>
<button onclick="createLink()">CreateServer</button>&nbsp;<button onclick="sendMsg()">Send</button> &nbsp;<button
        onclick="closeServer()">Close
</button>
<div id="content"></div>
&nbsp;
</body>
</html>
