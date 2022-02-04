package org.grigorovich.config;

/**
 * Пришлось закомментировать, потому что не пускает в Postman
 */

//@EnableWebSecurity
//public class MySecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        UserBuilder userBuilder= User.withDefaultPasswordEncoder();
//        auth.inMemoryAuthentication()
//                .withUser(userBuilder.username("Veronika").password("1").roles("ADMIN"))
//                .withUser(userBuilder.username("Elena").password("1").roles("TEACHER"))
//                .withUser(userBuilder.username("Ivan").password("1").roles("STUDENT"));
//    }
//
//    @Override //делаем авторизацию
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/", "/noahSmith").hasAnyRole("ADMIN","STUDENT")
//                .antMatchers("/", "/allStudentsOfMath", "/saveMathCourse" ,"/updateMathCourse").hasAnyRole("ADMIN","TEACHER")
//                .antMatchers("/**").hasRole("ADMIN")
//                .and().formLogin().permitAll();
//    }
//}
