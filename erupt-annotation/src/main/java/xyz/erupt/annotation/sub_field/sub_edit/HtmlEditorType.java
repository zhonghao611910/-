package xyz.erupt.annotation.sub_field.sub_edit;

import xyz.erupt.annotation.config.Comment;

/**
 * @author liyuepeng
 * @date 2020-02-15
 */
public @interface HtmlEditorType {

    @Comment("富文本编辑器类型")
    Type value();

    enum Type {
        CKEDITOR, UEDITOR
    }
}
