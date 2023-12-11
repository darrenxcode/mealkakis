import { RestaurantSubmission } from "./restaurantsubmission";

export class JoinSessionResponse {
    emitter: any;
    submissions: RestaurantSubmission[];
  
    constructor(emitter: any, submissions: RestaurantSubmission[]) {
      this.emitter = emitter;
      this.submissions = submissions;
    }
  }