JSON Web Token GetStart
SpringBoot + SpringSecurity + JWT + Postgres

User management token based(Please note the CSRF not in JWT based, refer to 
https://www.baeldung.com/spring-security-csrf
https://security.stackexchange.com/questions/170388/do-i-need-csrf-token-if-im-using-bearer-jwt)

Ultimate doc for the view mapping to the static html file
    
    //ultimate for the view setup
    //Static File Configuration
    //https://github.com/PeaceUCR/SpringBootInDepth readme
    // can access from http://localhost:8080/template/changepassword.html
    //what if reach form /view
    //https://stackoverflow.com/questions/37498305/spring-boot-url-mapping-for-static-html?rq=1
    //https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc-static-content
    //https://stackoverflow.com/questions/37498305/spring-boot-url-mapping-for-static-html?rq=1
   
JSP view mapping seems not for html

https://www.udemy.com/java-spring-framework-masterclass/learn/v4/t/lecture/10640070?start=0
https://stackoverflow.com/questions/16598594/how-to-map-requests-to-html-file-in-spring-mvc

# InDepth Development 
**from https://github.com/PeaceUCR/SpringSecurityJWT and https://github.com/PeaceUCR/MyStore**


How to handle the enum collection in JPA

https://stackoverflow.com/questions/416208/jpa-map-collection-of-enums

    @ElementCollection(targetClass=Role.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    
if not fetch eager, will cause https://stackoverflow.com/questions/11746499/how-to-solve-the-failed-to-lazily-initialize-a-collection-of-role-hibernate-ex
https://stackoverflow.com/questions/2990799/difference-between-fetchtype-lazy-and-eager-in-java-persistence-api?noredirect=1&lq=1


AuditModel.java
Date not created.... cause  when new User at signup
https://stackoverflow.com/questions/40370709/createddate-annotation-does-not-work-with-mysql

    org.postgresql.util.PSQLException: ERROR: null value in column "created_at" violates not-null constraint

@SpringBootApplication
@EnableJpaAuditing


**Change the validation based from username to email**

In service and controller, findByEmail instead of findByUsername

MyUserDetails.java: use Email as Username


**CORS&CSRF In-depth**


Test with https://github.com/PeaceUCR/MyStoreUI for CORS access localhost:3000, localhost:8080

when test with http://localhost:3000/signin, singin is fine, because (in WebSecurityConfig.java)

                .antMatchers("/users/signin").permitAll()

But after sign-in, the http://localhost:8080/users/me will has 403 error.
https://stackoverflow.com/questions/19468209/spring-security-403-error

Seems not working even http.csrf().disable()

Let's try add
    
            // for cors options preflight
            web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");

Then seems works fine, amazing, why it automatically support CORS?(Possible here https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/src/main/java/com/example/demo/config/RestConfiguration.java)

And //@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600) at Controller works as well
https://www.baeldung.com/spring-cors


I delete this file, then No 'Access-Control-Allow-Origin' header will be here

So Create a CORSFilter.java Here (Not Manually set order like https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/src/main/java/com/example/demo/config/RestConfiguration.java)
Try https://github.com/PeaceUCR/MyStore/blob/master/src/main/java/com/example/demo/filter/CORSFilter.java
then configure at JwtTokenFilterConfigurer.java

**Why this way not working in this app, but works in my_store, abandoned**
use https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/src/main/java/com/example/demo/config/RestConfiguration.java
This will works.(Pending this issue may discuss in the future)

https://stackoverflow.com/questions/31724994/spring-data-rest-and-cors/31748398#31748398


--------------------CORS Ends--------------------------------------

Why UserResponseDTO.java

Yes, we can direct return User as response, but it should not include the password/update_date.

So use a new model exclude that.


-----------Email add-on for sign-up and change password-----------

Part of configuration will from

https://github.com/PeaceUCR/MyStore/blob/master/src/main/java/com/example/demo/config/EmailConfig.java


###########################################################################
Challenge here:
(login then generate token, access with token, filter resolve info from token then check and grant auth)
How to add a filter to resolve the token and transfer to auth  
https://stackoverflow.com/questions/42354138/spring-security-token-based-authentication

GenericFilterBean vs Filter???  
JwtTokenFilterConfigurer extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>???  
http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider)); ????

Why this statement? How it works?

**Before discuss the difference of these two filters, first check the build-in filter for Spring-Security**

https://stackoverflow.com/questions/10140515/spring-security-where-can-i-find-the-list-of-all-security-filters-registered-w
Spring Security Filter Orders (7.3 Filter Ordering)
https://docs.spring.io/spring-security/site/docs/3.0.x/reference/security-filter-chain.html

Authentication processing mechanisms - UsernamePasswordAuthenticationFilter(used at our app)

So We must set our token processing filter process the request before reach UsernamePasswordAuthenticationFilter(otherwise always unauthorized response will return)
//Set Order not working with Spring Security
https://stackoverflow.com/questions/25957879/filter-order-in-spring-boot
https://stackoverflow.com/questions/40471429/how-can-i-add-custom-filter-order-after-spring-security-filter

So create GenericFilterBean then configure the order in  JwtTokenFilterConfigurer.java, then apply in WebSecurityConfig.java


  


# How to Use

![alt text](https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/signup.png?raw=true)
![alt text](https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/signin.png?raw=true)
![alt text](https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/view.png?raw=true)


# /security/JwtTokenFilter

The JwtTokenFilter filter is applied to each API (/**) with exception of the signin token endpoint (/users/signin) and singup endpoint (/users/signup).

This filter has the following responsibilities:

1.Check for access token in Authorization header. If Access token is found in the header, delegate authentication to JwtTokenProvider otherwise throw authentication exception

2.Invokes success or failure strategies based on the outcome of authentication process performed by JwtTokenProvider
Please ensure that chain.doFilter(request, response) is invoked upon successful authentication. You want processing of the request to advance to the next filter, because very last one filter FilterSecurityInterceptor#doFilter is responsible to actually invoke method in your controller that is handling requested API resource.
![alt text](https://github.com/PeaceUCR/SpringSecurityJWT/blob/master/JwtTokenFilter.png?raw=true)

# /security/JwtTokenFilterConfigurer

Adds the JwtTokenFilter to the DefaultSecurityFilterChain of spring boot security.
https://medium.com/@xoor/jwt-authentication-service-44658409e12c

# /security/JwtTokenProvider
The JwtTokenProvider has the following responsibilities:

1.Verify the access token's signature
2.Extract identity and authorization claims from Access token and use them to create UserContext
3.If Access token is malformed, expired or simply if token is not signed with the appropriate signing key Authentication exception will be thrown

# /security/MyUserDetails
Implements UserDetailsService in order to define our own custom loadUserbyUsername function. The UserDetailsService interface is used to retrieve user-related data. It has one method named loadUserByUsername() which finds a user entity based on the username and can be overridden to customize the process of finding the user.

It is used by the DaoAuthenticationProvider to load details about the user during authentication.


# /config/WebSecurityConfig

The WebSecurityConfig class extends WebSecurityConfigurerAdapter to provide custom security configuration.

Following beans are configured and instantiated in this class:

JwtTokenFilter

PasswordEncoder

Also, inside WebSecurityConfig#configure(HttpSecurity http) method we'll configure patterns to define protected/unprotected API endpoints. Please note that we have disabled CSRF protection because we are not using Cookies.

REF:  
https://medium.com/@xoor/jwt-authentication-service-44658409e12c  
https://github.com/murraco/spring-boot-jwt
