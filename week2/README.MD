## 1) HTTP 통신에 관하여

HTTP(HyperText Transfer Protocol)은 인터넷 프로토콜 스위트의 어플리케이션 레이어 프로토콜이다.

기본적인 태생을 하이퍼텍스트(html) 전송을 위한 프로토콜이였으나, 현재 대다수의 정보를 HTTP나 HTTPS를 통해 전송한다.

HTTP는 TCP기반 프로토콜로 TCP 포트를 사용하며 일반적으로 네임드 포트 80은 HTTP에 할당한다.  

<br/><br/>
### HTTP request methods

HTTP는 총 9가지의 request method를 규정하고 있으며, 해당 request method의 이름을 request 맨 첫부분에 첨부되며

이에 따라 구별이 된다.

*Request Header의 POST 예시

![image](https://user-images.githubusercontent.com/57210973/129301014-43ddfe5d-eacc-4ff9-b222-935168a267bd.png)


HTTP request method의 종류

GET : 일반적으로 특정된 리소스를 요청하는 method.

HEAD : GET와 같이 요청하나 Response에 body는 제외 요청

POST : 일반적으로 특정 리소스 전송

PUT: 일반적으로 특정 리소스를 다른 데이터로 덮어쓰기 위한 메소드로 쓰임

DELETE : 특정 리소스 삭제 요청

CONNECT : 특정 리소스를 기반으로 데이터와 연결 요청

OPTION : 특정 리소스에 대한 선택지 요청

TRACE : 특정 리소스에 대해 message loop back 요청. 정상적으로 실행될 시 request 메시지를 다시 전송되는 것이 일반적
 
PATCH : 특정 리소스의 일부분 수정 요청  


<br/><br/>
### HTTP response

HTTP response의 종류는 3자리 숫자 Code로 구별되며 해당 코드들은 가장 앞자리의 숫자로 분류되며 숫자는 1에서 5까지 존재한다.

##### 1XX : 정보에 관한 response

##### 2XX : 성공적인 request에 대한 response

##### 3XX : redirection에 대한 response

##### 4XX : client 오류에 관한 response

##### 5XX : server에 관한 response

해당 response code 이후에 HTTP protocol에 관한 정보 및 헤더가 있으며,

마지막에 response body가 있을 시 response body에 요청한 리소스가 담긴다.  




<br/><br/>
<br/><br/>

## 2) 브라우저에 URL을 입력 후 요청하여 서버에서 응답하는 과정까지에 대해 학습 한 내용을 작성

URL을 브라우저에 입력시 브라우저는 지원하는 프로토콜중 하나를 골라 실행한다. URL에 프로토콜이 명시되어 있지 않으면

브라우저는 기본적으로 HTTP(S) 프로토콜을 우선적으로 실행하며 이 경우 HTTP는 TCP기반 프로코톨이며 

TCP는 일반적으로 IP 프로코콜 이용하여 구현하기 때문에 IP가 필요하다.

URL자체에 IP가 있을 수 있으나 없는 경우가 일반적이며 이러한 경우 DNS을 통해 URL 도메인을 query하며

적절한 IP를 알아낸다.


![image](https://user-images.githubusercontent.com/57210973/129309932-25c9028d-3421-47fb-905b-29e60c7b91dd.png)



해당 IP 및 URL에 명시된 포트(없을 시 프로토콜의 네임드 포트 이용)를 통해 http request를 보낸다.

보낼 때 HTTP는 TCP를 이용하며, 같은 호스트에 여러 http request 있을 시 기존 하나의 connection에 request pipelining한다.

![image](https://user-images.githubusercontent.com/57210973/129310524-4460453d-5e1c-49f1-8918-3306a05471b0.png)


Request를 받은 서버 또한 같은 TCP 연결에 Response를 클라이언트 브라우저에 전송하며 전송 응답이 끝난다.



