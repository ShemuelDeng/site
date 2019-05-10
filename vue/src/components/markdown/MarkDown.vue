<template>
    <div>
    </div>
</template>

<script>
    export default {
        name: 'MarkDown',
        data () {
            return { content: '', html: '' };
        },
        computed: {
            simplemde () {
                return this.$refs.markdownEditor.simplemde;
            }
        },
        // mounted () {
        //     console.log(this.simplemde);
        // },
        methods: {
            toHtml () {
                return this.content;
            }
        }
    };
</script>

<style scoped>
</style>
