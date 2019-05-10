<template>
    <div>
        <vue-fab
            icon="add"
            fab-item-animate="default"
            main-btn-color="#ff9900"
        >
            <fab-item
                icon="edit"
                :idx="0"
                title="写文章"
                @clickItem="addBlog"
            >
            </fab-item>
            <fab-item
                icon="edit"
                :idx="1"
                title="写留言"
                @clickItem="addMessage"
            >
            </fab-item>
        </vue-fab>
        <div>
            <Modal
                v-model="articleDialog"
                :closable="false"
                :mask-closable="false"
                title="写文章"
                width="80"
                on-visible-change="change"
            >
                <div>
                    <i-input
                        v-model="title"
                        placeholder="请输入文章标题"
                    >
                        <span slot="prepend">标题</span>
                    </i-input>
                    <markdown-editor
                        ref="markdownEditor"
                        v-model="content"
                        :sanitize="true"
                    ></markdown-editor>
                </div>
                <div slot="footer">
                    <Button @click="articleDialog = false">
                        关闭
                    </Button>
                    <Button
                        type="primary"
                        :loading="saveLoading"
                        @click="saveArticle"
                    >
                        发表
                    </Button>
                </div>
            </Modal>
            <Modal
                v-model="messageDialog"
                :closable="false"
                :mask-closable="false"
                title="写留言"
                ok-text="留言"
                cancle-text="取消"
                on-visible-change="change"
                @on-ok="saveMessage"
                @on-cancel="messageDialog = false"
            >
                <i-input
                    v-model="message"
                    type="textarea"
                    :rows="4"
                    placeholder="留个言吧"
                ></i-input>
                <div slot="footer">
                    <Button @click="messageDialog = false">
                        关闭
                    </Button>
                    <Button
                        type="primary"
                        :loading="saveLoading"
                        @click="saveMessage"
                    >
                        留言
                    </Button>
                </div>
            </Modal>
        </div>
    </div>
</template>

<script>
    import { mapActions } from 'vuex';
    export default {
        name: 'FloatButton',
        data () {
            return {
                articleDialog: false,
                messageDialog: false,
                saveLoading: false,
                content: '',
                title: '',
                message: ''
            };
        },
        created () {
        },
        methods: {
            ...mapActions([
                'insert',
                'getArticles'
            ]),
            addMessage () {
                this.messageDialog = true;
            },
            addBlog () {
                // this.$router.push('/test3');
                this.articleDialog = true;
            },
            saveArticle () {
                this.saveLoading = true;
                import('showdown').then(showdown => {
                    const converter = new showdown.Converter();
                    let params = {
                        title: this.title,
                        content: converter.makeHtml(this.content)
                    };
                    let paramObj = {
                        tableName: 'Article',
                        data: JSON.stringify(params)
                    };
                    this.insert(paramObj).then(res => {
                        if (res.status === 1) {
                            this.$Message.success('发表成功');
                        } else {
                            this.$Message.error(`发表失败:${res.message}`);
                        }
                        this.title = '';
                        this.content = '';
                        this.articleDialog = false;
                        this.saveLoading = false;
                    });
                });
            },
            saveMessage () {
                let params = {
                    content: this.message
                };
                let paramObj = {
                    tableName: 'message',
                    data: JSON.stringify(params)
                };
                if (this.isEmpty(this.message)) {
                    this.$Message.info('写点啥呗...');
                } else if (this.message.indexOf('傻') !== -1) {
                    this.$Message.warning('文明人不说敏感词汇哦');
                } else {
                    this.saveLoading = true;
                    this.insert(paramObj).then(res => {
                        if (res.status === 1) {
                            this.$notify({
                                title: '留言成功',
                                message: '感谢留言,我已收到了您的消息',
                                type: 'success'
                            });
                        } else {
                            this.$notify({
                                title: '留言失败',
                                message: `留言失败:${res.message},请联系网站负责人`,
                                type: 'error'
                            });
                        }
                        this.message = '';
                        this.messageDialog = false;
                        this.saveLoading = false;
                    });
                }
            },
            change (status) {
                if (!status) {
                    this.title = '';
                    this.content = '';
                    this.message = '';
                }
            }
        }
    };
</script>

<style scoped>

</style>
