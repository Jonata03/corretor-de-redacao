import { createStore } from 'vuex'

const store = createStore({
    state: {
        myState: 'valorInicial',
    },
    mutations: {
        myMutation(state, payload) {
            state.myState = payload
        },
    },
    actions: {
        myAction({ commit }, payload) {
            commit('myMutation', payload)
        },
    },
})

export default store