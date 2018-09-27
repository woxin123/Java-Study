package top.mcwebsite.client.beans;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 服务期信息
 * @author mengchen
 * @time 18-9-19 下午8:38
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServerInfo {
    /**
     * 服务器URL
     */
    private String url;
}
