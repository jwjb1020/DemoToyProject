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