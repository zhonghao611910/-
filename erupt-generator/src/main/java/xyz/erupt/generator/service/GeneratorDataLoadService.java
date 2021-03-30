package xyz.erupt.generator.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import xyz.erupt.core.util.ProjectUtil;
import xyz.erupt.generator.model.GeneratorClass;
import xyz.erupt.jpa.dao.EruptDao;
import xyz.erupt.upms.constant.MenuTypeEnum;
import xyz.erupt.upms.model.EruptMenu;

import javax.transaction.Transactional;

/**
 * @author liyuepeng
 * @date 2019-07-15.
 */
@Service
@Order
@Slf4j
public class GeneratorDataLoadService implements CommandLineRunner {

    @Autowired
    private EruptDao eruptDao;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        new ProjectUtil().projectStartLoaded("generator", first -> {
            if (first) {
                String generator = "$generator", code = "code";
                EruptMenu eruptMenu = eruptDao.persistIfNotExist(EruptMenu.class, new EruptMenu(generator, "代码生成", null, null, 1, 40, "fa fa-code", null), code, generator);
                eruptDao.persistIfNotExist(EruptMenu.class, new EruptMenu(GeneratorClass.class.getSimpleName(), "生成Erupt代码", MenuTypeEnum.TABLE.getCode(), GeneratorClass.class.getSimpleName(),
                        Integer.valueOf(EruptMenu.OPEN), 0, null, eruptMenu), code, GeneratorClass.class.getSimpleName());
            }
        });
    }

}
