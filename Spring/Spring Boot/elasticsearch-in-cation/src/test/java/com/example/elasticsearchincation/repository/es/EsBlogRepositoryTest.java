package com.example.elasticsearchincation.repository.es;

import com.example.elasticsearchincation.domain.es.EsBlog;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * EsBlog Repository接口测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsBlogRepositoryTest {

    @Autowired
    private EsBlogRepository esBlogRepository;

    @Before
    public void initRepositoryData() {
        // 清楚所有数据
        esBlogRepository.deleteAll();

        esBlogRepository.save(new EsBlog("红豆", "王维的红豆", "红豆生南国，春来发几枝。" +
                "愿君多采撷，此物最相思。"));
        esBlogRepository.save(new EsBlog("早发白帝城", "李白的早发白帝城", "朝辞白帝彩云间，千里江陵一日还。" +
                "两岸猿声啼不住，轻舟已过万重山。"));
        esBlogRepository.save(new EsBlog("静夜思", "李白的静夜思", "床前明月光，疑是地上霜。" +
                "举头望明月，低头思故乡。"));
    }

    @Test
    public void testfindDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining() {
        Pageable pageable = new PageRequest(0, 20);
        String title = "思";
        String summary = "相思";
        String content = "相思";
        Page<EsBlog> page = esBlogRepository.findDistinctEsBlogByTitleContainingOrSummaryContainingOrContentContaining(title, summary, content, pageable);
        assertThat(page.getTotalElements()).isEqualTo(1);

        for (EsBlog blog : page) {
            System.out.println(blog.toString());
        }

    }
}
