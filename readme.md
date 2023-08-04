# 이곳은 springboot backend
## 진행상황
### 2023.07.31 
- entity, repository, service, controller 까지 만들고 실행되는 것 확인
- 원래 Maven으로 만들었지만 gradle로 다시 만들어봄
  
## 2023.07.31
- cors 정책 

<code>
    build.gradle에추가해주세요.


    implementation  'org.springframework.boot:spring-boot-starter-validation'
</code>


- spring boot 버전으로 인해서 JWT토큰 하는 방식에 추가적으로 설정 필요! 


<code>
    build.gradle에추가해주세요.

    implementation 'io.jsonwebtoken:jjwt:0.9.1'   
    implementation group: 'javax.xml.bind', name: 'jaxb-api', version: '2.3.1'
    implementation group: 'com.sun.xml.bind', name: 'jaxb-core', version: '2.3.0.1'
    implementation group: 'com.sun.xml.bind', name: 'jaxb-impl', version: '2.3.1'
</code>  

## 2023.08.02
- MySql에 데이터를 저장할때 import방식으로 하면 지정한 포린키가 초기화되는 문제

    springboot에 service 폴더에 새로운 클래스 만듬<br>
    build.gradle에 poi와 관련된 excel읽을 수 있는 implemention 추가해야함<br>
    entity폴더와 repository폴더에 있는 파일들 수정해야함.<br>
    data폴더 만들어서 안에 excel파일 데이터 저장해놓음<br>
    데이터입력의 자세한 방법은 DataInput 클래스 안에 주석으로 처리함.

## 2023.08.04
- cors 정책 에러로 인해 configuration 폴더를 만들어 새롭게 webConfig 클래스를 만듬
    
    -> 하지만 나중에 jwtsecurtiy로 변경할것!<br>
    jwtsercurity로 만들면 controller와 service 클래스가 없어도 된다고 함.

- 프론트엔드에서 데이터를 받아 response로 전달할때 어떠한 메세지가 오는지 구별하기 위해서 메세지를 다 다르게 변경함.
- 원래 백앤드 서버에 이미지파일을 저장하려고 했지만 요청받을 때마다 불러와야하기 때문에 
        로고나 버튼 등 서버와 관련없는 파일들은 프론트엔드에 저장하고 <br>
        축제나 숙소와 관련된 파일들은 백앤드에 저장하려고함.