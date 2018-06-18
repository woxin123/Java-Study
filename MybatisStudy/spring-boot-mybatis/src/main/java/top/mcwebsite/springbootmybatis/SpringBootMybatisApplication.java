package top.mcwebsite.springbootmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.mcwebsite.springbootmybatis.mapper.CountryMapper;

@SpringBootApplication
@MapperScan(
        value = {
                "top.mcwebsite.springbootmybatis.mapper"
        }
)
public class SpringBootMybatisApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisApplication.class, args);
    }

    @Autowired
    private CountryMapper countryMapper;

    @Override
    public void run(String... args) throws Exception {
        countryMapper.selectAll();
    }
}
