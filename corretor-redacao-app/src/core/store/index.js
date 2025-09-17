import state from './comum';
import tema from './tema';
import vuex from "vuex";

export default new vuex.Store({
    state,
    modules: {
        tema,
    }}
);

