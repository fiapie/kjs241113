package skyds.example.first;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import skyds.example.first.repository.JdbcMemberRepository;
import skyds.example.first.repository.JdbcTemplateMemberRepository;
import skyds.example.first.repository.MemberRepository;
import skyds.example.first.repository.MemoryMemberRepository;
import skyds.example.first.service.MemberService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository();
//        return new JdbcTemplateMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
    }
}