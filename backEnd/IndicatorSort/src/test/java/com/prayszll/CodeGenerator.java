package com.prayszll;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url = "jdbc:mysql:///xdb";
        String username = "root";
        String password = "123456";
        String moduleName = "sys";
        String mapperLocation = "E:\\programs\\IndicatorSort\\backEnd\\IndicatorSort\\src\\main\\resources\\mapper\\" + moduleName;
        String tables = "monitoring,indicatorData";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("prayszll") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            //.fileOverride() // 覆盖已生成文件
                            .outputDir("E:\\programs\\IndicatorSort\\backEnd\\IndicatorSort\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder -> {
                    builder.parent("com.prayszll") // 设置父包名
                            .moduleName(moduleName) // 设置父包模块名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)); // 设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude(tables) // 设置需要生成的表名
                            .addTablePrefix("x_"); // 设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
