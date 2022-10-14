# 코인노래방 키오스크
# 코인노래방의 전반적인 이용을 위한 Java 기반의 키오스크 프로그램
#### 프로젝트 개발 기간 : 2021.10 ~ 2021.11
-----------------------
## Description
### PART 1. 프로그램 제공 기능
 - 방 기능
 - 회원가입/로그인 및 로그아웃 기능
 - 코인 사용하기 및 시작하기 기능
 - 잔여 코인, 회원 이름, 회원 아이디 조회 기능
 - 코인 충전 기능
 - 사용 중인 방은 다른 색상으로 구분해주는 기능
 - 회원관리(회원정보 조회, 갱신, 수정, 병합, 삭제)가 가능한 관리자 모드 기능
 
### PART 2. 프로그램 구성
 ![schema](https://user-images.githubusercontent.com/77719450/195053425-32e61ba7-056d-484e-816d-1ce7e020e2a9.png)
 
 
### PART 3. 화면 구성 및 세부 기능
 - FirstFrame.java
 
 ![FirstFrame](https://user-images.githubusercontent.com/77719450/195063363-e1eab384-91fe-494a-835f-3a5c5d23b1ce.PNG)
 
 - 'ENTRANCE' 버튼 클릭 시, 초기 방 선택 화면(SecondFrame.java)으로 이동
 -----------------------
 - SecondFrame.java
 
 ![SecondFrame](https://user-images.githubusercontent.com/77719450/195063484-9b1ca027-3a1c-4b9e-a8af-8e92214cd541.PNG)
 
 - 사용 중인 방은 하늘 색으로 표시
 - 빈 방 버튼 클릭 시, 방 화면(ChooseRoom.java)으로 이동함과 동시에 로그인 화면(LoginFrame.java) 표시
 - 사용 중인 방 버튼 클릭 시, 방 화면(ChooseRoom.java)으로 이동
 - 비상구 버튼 클릭 시, 관리자 로그인 화면(AdminLoginFrame.java)으로 이동
 -----------------------
 - ChooseRoom.java
 
 ![ChooseRoom](https://user-images.githubusercontent.com/77719450/195063524-034b12c3-b36d-423d-bd9f-0012882260a8.PNG)
 
 - 차이를 둔 패밀리 룸과 스탠다드 룸 배경 이미지
 - OFFLINE 상태에서 'Back' 버튼 클릭 시, 초기 방 선택 화면(SecondFrame.java)으로 이동
 - ONLINE 상태에서 'Back' 버튼 클릭 시, 초기 방 선택 화면(SecondFrame.java)으로 이동함과 동시에 사용 중인 방으로 표시
 - OFFLINE 상태에서 비밀번호 입력 후 '로그아웃' 버튼 클릭 시, "로그인이 필요합니다." 경고문 표시
 - ONLINE 상태에서 잘못된 비밀번호 입력 후 '로그아웃' 버튼 클릭 시, "비밀번호가 맞지 않습니다." 경고문 표시
 - ONLINE 상태에서 올바른 비밀번호 입력 후 '로그아웃' 버튼 클릭 시, "로그아웃 성공" 메시지 표시
 - "로그아웃 성공" 메시지에서 'OK' 버튼 클릭 시 OFFLINE 상태가 되고, 초기 방 선택 화면(SecondFrame.java)으로 이동함과 동시에 빈 방으로 표시
 - OFFLINE 상태에서 '입장하기' 버튼 클릭 시, "로그인이 필요합니다." 경고문 표시
 - ONLINE 상태에서 '입장하기' 버튼 클릭 시, 세부 방 화면(RoomFrame.java)으로 이동
 -----------------------
 - LoginFrame.java
 
 ![LoginFrame](https://user-images.githubusercontent.com/77719450/195063549-963ab7d4-13fa-4485-af21-89ef2f395064.PNG)
 
 - 아이디를 입력하지 않고 '로그인' 버튼 클릭 시, "아이디를 입력해 주세요." 경고문 표시
 - 아이디만 입력 후 '로그인' 버튼 클릭 시, "비밀번호를 입력해 주세요." 경고문 표시
 - 존재하지 않는 아이디를 입력하거나 잘못된 비밀번호를 입력 후 '로그인' 버튼 클릭 시, "로그인 실패" 경고문 표시
 - 올바른 아이디와 비밀번호 입력 후 '로그인' 버튼 클릭 시, "로그인 성공" 메시지 표시
 - "로그인 성공" 메시지에서 'OK' 버튼 클릭 시 ONLINE 상태가 되고, 로그인 화면(LoginFrame.java) 제거
 - '회원가입' 버튼 클릭 시, 회원가입 화면(JoinFrame.java)으로 이동
 -----------------------
 - JoinFrame.java
 
 ![JoinFrame](https://user-images.githubusercontent.com/77719450/195063577-816aa706-6b3d-4f50-81f5-cf5ea6a7d873.PNG)

 - 'Back' 버튼 클릭 시, 방 화면(ChooseRoom.java)으로 이동함과 동시에 로그인 화면(LoginFrame.java) 표시
 - 성명을 입력하지 않고 '회원가입' 버튼 클릭 시, "성명을 입력해 주세요." 경고문 표시
 - 존재하지 않는 아이디를 입력 후 '중복 확인' 버튼 클릭 시, "사용 가능한 아이디입니다." 메시지 표시
 - 존재하는 아이디를 입력 후 '중복 확인' 버튼 클릭 시, "이미 사용중인 아이디입니다." 경고문 표시
 - 아이디를 입력 후 '중복 확인' 버튼을 클릭하지 않은 채로 '회원가입' 버튼 클릭 시, "아이디 중복 확인이 필요합니다." 경고문 표시
 - 비밀번호만 입력하지 않고 '회원가입' 버튼 클릭 시, "비밀번호를 입력해 주세요." 경고문 표시
 - 비밀번호확인만 입력하지 않고 '회원가입' 버튼 클릭 시, "비밀번호 확인을 입력해 주세요." 경고문 표시
 - 비밀번호와 비밀번호확인 입력 값이 다른 상태에서 '회원가입' 버튼 클릭 시, "비밀번호가 같지 않습니다." 경고문 표시
 - 올바른 값 입력 후 '회원가입' 버튼 클릭 시, 방 화면(ChooseRoom.java)으로 이동함과 동시에 로그인 화면(LoginFrame.java) 표시
 -----------------------
 - RoomFrame.java
 
 ![RoomFrame](https://user-images.githubusercontent.com/77719450/195063608-87f82b9f-0375-46c0-a007-99541f684154.PNG)

 - 차이를 둔 패밀리 룸과 스탠다드 룸 배경 이미지
 - 회원 성명과 아이디 표시
 - 잔여 코인과 사용 중인 코인 표시
 - 'Back' 버튼 클릭 시, 방 화면(ChooseRoom.java)으로 이동
 - '충전하기' 버튼 클릭 시, 충전 화면(ChargeFrame.java)으로 이동
 - 곡 수 버튼(1곡, 2곡, 3곡, 5곡, 10곡, 20곡)과 '사용하기', '시작하기' 버튼 표시
 - n곡 버튼 클릭 시, 하단 빈 칸에 n 표시
 - 곡 수(n) 표시된 상태에서 '사용하기' 버튼 클릭 시, "n곡 사용하시겠습니까?" 메시지 표시
 - "n곡 사용하시겠습니까?" 메시지에서 'Yes' 버튼 클릭 시, 잔여 코인에서 n곡 차감하고 사용 중인 코인에서 n곡 증감
 - "n곡 사용하시겠습니까?" 메시지에서 'Yes' 버튼 클릭 시 잔여 코인보다 n곡이 크다면, "잔여 곡이 없습니다." 경고문 표시
 - 사용 중인 코인이 0인 상태에서 '시작하기' 버튼 클릭 시, "사용 중인 곡이 없습니다." 경고문 표시
 - 사용 중인 코인이 1 이상인 상태에서 '시작하기' 버튼 클릭 시, 사용 중인 코인 1씩 차감
 - 사용 중인 코인이 존재하는 상태에서 로그아웃 시, 사용 중인 코인 0으로 초기화
 -----------------------
 - ChargeFrame.java
 
 ![ChargeFrame](https://user-images.githubusercontent.com/77719450/195063628-829ab95e-9be1-4000-bebd-d6e1536e75ae.PNG)

 - 회원 성명과 아이디 표시
 - 'Back' 버튼 클릭 시, 세부 방 화면(RoomFrame.java)으로 이동
 - 곡 수 버튼(1곡, 2곡, 3곡, 5곡, 10곡, 20곡)과 '충전하기' 버튼 표시
 - n곡 버튼 클릭 시, 하단 빈 칸에 n 표시
 - 곡 수(n) 표시된 상태에서 '충전하기' 버튼 클릭 시, "충전이 완료 되었습니다." 메시지 표시
 -----------------------
 - AdminLoginFrame.java
 
 ![AdminLoginFrame](https://user-images.githubusercontent.com/77719450/195063647-2a0fd18a-91ac-4604-94e4-aedc2f1ee9d3.PNG)

 - 관리자는 오직 한 계정만 존재
 - 'Back' 버튼 클릭 시, 초기 방 선택 화면(SecondFrame.java)으로 이동
 - 아이디 혹은 비밀번호를 입력하지 않고 '로그인' 버튼 클릭 시, "로그인 실패" 경고문 표시
 - 올바른 값 입력 후 '로그인' 버튼 클릭 시, "로그인 성공" 메시지 표시
 - "로그인 성공" 메시지에서 'OK' 버튼 클릭 시, 관리자 모드(AdminFrame.java)로 이동
 - 관리자가 존재하는 상태에서 '관리자가입' 버튼 클릭 시, "관리자가 존재합니다." 경고문 표시
 - 관리자가 존재하지 않은 상태에서 '관리자가입' 버튼 클릭 시, 관리자 가입 화면(AdminJoinFrame.java)으로 이동
 -----------------------
 - AdminJoinFrame.java
 
 ![AdminJoinFrame](https://user-images.githubusercontent.com/77719450/195063672-d74236e4-525f-42c1-bc43-d659614cc46c.PNG)

 - 'Back' 버튼 클릭 시, 관리자 로그인 화면(AdminLoginFrame.java)으로 이동
 - 성명을 입력하지 않고 '관리자가입' 버튼 클릭 시, "성명을 입력해 주세요." 경고문 표시
 - 아이디만 입력하지 않고 '관리자가입' 버튼 클릭 시, "아이디를 입력해 주세요." 경고문 표시
 - 비밀번호만 입력하지 않고 '관리자가입' 버튼 클릭 시, "비밀번호를 입력해 주세요." 경고문 표시
 - 비밀번호확인만 입력하지 않고 '관리자가입' 버튼 클릭 시, "비밀번호 확인을 입력해 주세요." 경고문 표시
 - 비밀번호와 비밀번호확인 입력 값이 다른 상태에서 '관리자가입' 버튼 클릭 시, "비밀번호가 같지 않습니다." 경고문 표시
 - 올바른 값 입력 후 '관리자가입' 버튼 클릭 시, 관리자 로그인 화면(AdminLoginFrame.java)으로 이동
 -----------------------
 - AdminFrame.java
 
 ![AdminFrame](https://user-images.githubusercontent.com/77719450/195063704-c5d1fb4f-308b-4aeb-af79-39fdf44e6aa0.PNG)

 - '탈출' 버튼 클릭 시, 관리자 로그인 화면(AdminLoginFrame.java)으로 이동
 - 회원 테이블 표시
 - 조회 입력란에 회원 테이블 키워드(성명 or 아이디 or 잔여 코인 or 사용 코인 or 방 or 상태) 입력 즉시, 관련된 회원 테이블만 표시
 - '갱신' 버튼 클릭 시, 회원 상세 정보 새로고침 후 표시
 - 회원 테이블 클릭 시, 하단에 해당 잔여 코인, 방 표시
 - 잔여 코인 혹은 방 수정 후 '수정' 버튼 클릭 시, 값 수정 후 자동 새로고침
 - 사용 코인이 0인 회원 테이블 클릭 후 '병합' 버튼 클릭 시, "사용 코인이 없습니다." 경고문 표시
 - 사용 코인이 n인 회원 테이블 클릭 후 '병합' 버튼 클릭 시, "사용 코인 n개를 잔여 코인으로 병합하시겠습니까?" 메시지 표시
 - "사용 코인 n개를 잔여 코인으로 병합하시겠습니까?" 메시지에서 'Yes' 버튼 클릭 시, 사용 코인에서 n개 차감하고 잔여 코인에서 n개 증감 후 자동 새로고침
 - 성명이 Name, 아이디가 ID회원 테이블 클릭 후 '삭제' 버튼 클릭 시, "Name (ID) 회원을 삭제하시겠습니까?" 메시지 표시
 - "Name (ID) 회원을 삭제하시겠습니까?" 메시지에서 'Yes' 버튼 클릭 시, 테이블 삭제 후 자동 새로고침
 -----------------------
## Environment

> Java version 11.0.12
> 
> MySQL version 8.0.26
>
> Eclipse IDE version 2020-06 (4.16.0)
