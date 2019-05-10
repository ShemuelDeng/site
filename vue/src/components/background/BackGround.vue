<template>
    <div>
        <vue-particles
            color="#dedede"
            :particle-opacity="0.7"
            :particles-number="80"
            shape-type="circle"
            :particle-size="4"
            lines-color="#dedede"
            :lines-width="1"
            :line-linked="true"
            :line-opacity="0.4"
            :lines-distance="150"
            :move-speed="3"
            :hover-effect="true"
            hover-mode="grab"
            :click-effect="true"
            click-mode="push"
        >
        </vue-particles>
    </div>
</template>

<script>
    export default {
        name: 'BackGround'
    };
</script>

<style scoped>

</style>
