package top.mcwebsite.bloguser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.mcwebsite.bloguser.domain.Authority;

/**
 * Authority 仓库.
 *
 * @since 1.0.0 2017年3月2日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long>{
}
