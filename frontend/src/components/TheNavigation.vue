<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container">
            <router-link :to="{name: 'home'}"
                         active-class=""
                         exact-active-class=""
                         class="navbar-brand">Plantero
            </router-link>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
                    aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <router-link v-for="(route, index) in routes" v-bind:key="index"
                                 :to="route"
                                 active-class=""
                                 exact-active-class="active"
                                 class="nav-item nav-link">{{ route.title }}
                    </router-link>
                </div>
            </div>
        </div>
    </nav>
</template>

<script>
    export default {
        name: 'Navigation',
        // data: function () {
        //     return {
        //         routes: []
        //     }
        // },
        // created() {
        //     this.routes = this.$router.options.routes;
        // }
        computed: {
            routes() {
                return this.$router.options.routes;
            }
        }
    }
</script>