package top.mcwebsite.bloguser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import top.mcwebsite.bloguser.domain.Vote;

/**
 * Vote 仓库.
 *
 * @since 1.0.0 2017年4月9日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public interface VoteRepository extends JpaRepository<Vote, Long>{
 
}
