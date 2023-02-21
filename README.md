## SSE로 구현하는 채팅

### ENDPOINT
`GET /chat/room`: 채팅방 페이지

#### _REST API_
`GET /chat/messages`: 채팅 메세지 반환<br>
`POST /chat/writeMessage`: 메세지 등록

---
### 프로젝트 소개
- 비동기 통신 방식(AJAX)로 rest api를 호출하도록 구현
- EventSource 객체를 생성하여 서버에서 이벤트를 수신하도록 함.

#### _**채팅 방식을 간단하게 요약하자면 아래와 같다**_
1. 채팅 메세지 등록 시 AJAX 방식으로 POST 요청
2. 서버에서 메세지 등록을 하고 emitter들에게 event 전송
3. event가 전달되었을때 메세지 호출을 위해 AJAX 방식으로 GET 요청