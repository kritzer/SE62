<template>
  <v-app>
    <v-row align="center" justify="center">
      <v-col cols="12" sm="8" md="4">
        <v-card
          tyle="width:100%;
                                margin:auto;
                                background-color:#FFFFFF"
          class="mx-auto pa-6"
          height="600"
          :elevation="25 - 1"
        >
          <v-card
            style="width:100%;
                                margin:auto;
                                background-color:#FFFFFF"
            class="mx-auto pa-6"
            height="550"
            :elevation="25 - 1"
          >
            <v-toolbar color="pink lighten-1" dark flat height="150">
              <v-toolbar-title class="font-weight-black display-1">WELCOME</v-toolbar-title>
              <v-spacer />
            
              <v-tooltip right>
                <span>Codepen</span>
              </v-tooltip>
            </v-toolbar>
            <v-container />
            <v-container />
            <v-card-text>
              <v-form>
                <v-text-field
                  label="Username"
                  v-model="user"
                  :rules="[(v) => !!v || 'This field is required']"
                  required
                  clearable
                  prepend-icon="mdi-account"
                  v-on:keyup.enter="Login"
                />

                <v-text-field
                  label="Password"
                  v-model="pass"
                  type="password"
                  prepend-icon="mdi-lock"
                  required
                  clearable
                  v-on:keyup.enter="Login"
                />
              </v-form>
              <v-container />
              <v-container />
              <v-container />
            </v-card-text>
            <v-card-actions>
              <v-spacer />
              <v-btn color="blue darken-2" text tile to="/rates">ให้คะแนนการใช้งาน</v-btn>
              <v-btn @click="Login" x-large color="red darken-3" :elevation="3 - 1">Login</v-btn>
            </v-card-actions>

          </v-card>
        </v-card>
      </v-col>
    </v-row>
  </v-app>
</template>

<script>
import http from "../http-common";
export default {
  name: "login",
  data() {
    return {
      user: "",
      pass: ""
    };
  },
  methods: {
    /* eslint-enable no-console */
    Login() {
      http
        .get("/check/" + this.user + "/" + this.pass)
        .then(response => {
          // eslint-disable-next-line no-console
          console.log(response);
          if (response.data[0] != null) {
            this.$router.push("/Home");
            http.post("/login/" + this.user);
            // eslint-disable-next-line no-unused-vars
            const options1 = { title: "Alert", size: "sm" };
            this.$dialogs.alert("เข้าสู่ระบบสำเร็จ", options1);
          } else {
            // eslint-disable-next-line no-unused-vars
            const options2 = { title: "Alert", size: "sm" };
            this.$dialogs.alert(
              "Username หรือ Password อาจจะผิดกรุณาเข้าสู่ระบบใหม่อีกครั้ง",
              options2
            );
          }
        })
        .catch(e => {
          // eslint-disable-next-line no-console
          console.log(e);
        });
      this.submitted = true;
    },
    refreshList() {}
    /* eslint-enable no-console */
  },
  mounted() {}
};
</script>
