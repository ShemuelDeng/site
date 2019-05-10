<template>
    <div class="body">
        <float-button></float-button>
        <div
            class="header"
            style="text-align:center"
        >
            aa
            <back-ground></back-ground>
        </div>
        <div class="content">
            <div style="margin-bottom: 30px">
                <Music></Music>
            </div>
            <div
                v-for="item in items"
                :key="item.id"
                style="margin-bottom: 30px"
            >
                <el-row :gutter="32">
                    <el-col
                        :xs="16"
                        :sm="16"
                        :md="16"
                        :lg="16"
                        :xl="16"
                    >
                        <el-card shadow="always">
                            <div slot="header">
                                <div style="width: 65%;float: left">
                                    <h1>
                                        {{ item.title }}
                                    </h1>
                                </div>
                                <div style="width: 30%;float: left">
                                    <span style="margin-right: 10px">{{ item.create_time }}</span>
                                </div>
                            </div>
                            <div
                                class="text item"
                                v-html="item.content"
                            >
                            </div>
                        </el-card>
                    </el-col>
                    <el-col
                        :xs="8"
                        :sm="8"
                        :md="8"
                        :lg="8"
                        :xl="8"
                    ></el-col>
                </el-row>
            </div>
            <Page
                :total="100"
                show-elevator
                :page-size="4"
                @on-change="pageChange"
            ></Page>
        </div>
        <div class="footer" ></div>
    </div>
</template>

<script>
    import BackGround from '../background/BackGround';
    import Music from '../music/Music';
    import FloatButton from '../button/FloatButton';
    import { mapActions } from 'vuex';
    export default {
        name: 'LayOut',
        components: { FloatButton, Music, BackGround },
        data () {
            return {
                number: 3,
                items: []
            };
        },
        created () {
            this.getArticles().then(res => {
                if (res.status === 1) {
                    this.items = res.data.list;
                }
            });
        },
        methods: {
            ...mapActions([
                'getArticles'
            ]),
            pageChange (value) {
                let obj = {
                    params: {
                        pageNum: value,
                        pageSize: 5
                    }
                };
                this.getArticles(obj).then(res => {
                    if (res.status === 1) {
                        this.items = res.data.list;
                    } else {
                        this.$Message.warning('加载失败');
                    }
                });
            }
        }
    };
</script>

<style scoped>
    .header{
        height: 400px;
        /*background-image: url("../../assets/images/bgimg.jpg");*/
        margin-bottom: 30px;
        background-color: gray;
    }
    .content{
        margin: auto;
        width: 70%;
    }
    .body{
        background-color: lightslategray;
    }
    .footer{
        height: 200px;
        /*background-image: url("../../assets/images/bgimg.jpg");*/
        background-color: lightsteelblue;
    }
</style>
