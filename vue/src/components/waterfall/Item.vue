<template>
    <div>
        <Waterfall
            ref="waterfall"
            :line="line"
            :line-gap="200"
            :min-line-gap="200"
            :max-line-gap="220"
            :watch="items"
            @reflowed="reflowed"
        >
            <WaterfallSlot
                v-for="(item, index) in items"
                :key="item.index"
                width="600"
                height="600"
                :order="index"
                move-class="item-move"
            >
                <div
                    class="item"
                    :index="item.index"
                    :style="item.style"
                    @click="click"
                >
                    <h1>hi</h1>
                </div>
            </WaterfallSlot>
        </Waterfall>
    </div>
</template>

<script>
    import WaterfallSlot from 'vue-waterfall/lib/waterfall-slot';
    import Waterfall from 'vue-waterfall/lib/waterfall';
    export default {
        name: 'Item',
        components: { Waterfall, WaterfallSlot },
        data () {
            let items = [
                {
                    index: 1,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 2,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 3,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 4,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 5,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 6,
                    style: {
                        background: this.getRandomColor()
                    }
                },
                {
                    index: 7,
                    style: {
                        background: this.getRandomColor()
                    }
                }
            ];

            return {
                line: 'h',
                items,
                isBusy: false
            };
        },
        methods: {
            shuffle: function () {
                this.items.sort(function () {
                    return Math.random() - 0.5;
                });
            },
            reflowed: function () {
                this.isBusy = false;
            },
            getRandomColor () {
                let colors = [
                    'rgba(21,174,103,.5)',
                    'rgba(245,163,59,.5)',
                    'rgba(255,230,135,.5)',
                    'rgba(194,217,78,.5)',
                    'rgba(195,123,177,.5)',
                    'rgba(125,205,244,.5)'
                ];
                return colors[~~(Math.random() * colors.length)];
            },
            click () {
                this.shuffle();
            },
            btnClick () {
                this.items.splice(0, 1);
            }
        }
    };
</script>

<style scoped>
.item-move {
    transition: all .5s cubic-bezier(.55,0,.1,1);
    -webkit-transition: all .5s cubic-bezier(.55,0,.1,1);
}
    .item{
        position: absolute;
        top: 5px;
        left: 5px;
        right: 5px;
        bottom: 5px;
        font-size: 1.2em;
        color: rgb(0,158,107);
        width: 500px;
        height: 500px;
    }
</style>
