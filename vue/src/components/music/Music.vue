<template>
    <div>
        <aplayer :music="musicObj"></aplayer>
    </div>
</template>

<script>
    import Aplayer from 'vue-aplayer';
    export default {
        name: 'Music',
        components: { Aplayer },
        data () {
            let musicObj = {
                title: 'Just the way you lie',
                artist: 'Eminem',
                src: 'http://www.ytmp3.cn/down/60633.mp3',
                pic: 'https://moeplayer.b0.upaiyun.com/aplayer/secretbase.jpg'
            };
            return { musicObj };
        }
    };
</script>

<style scoped>

</style>
