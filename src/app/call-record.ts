export interface CallRecord {
  id: string;
  callDuration: number;
  callStartTime: string;
  callEndTime: string;
  callActive: boolean;
  phoneNumber: string;
  subscriberID: string;
}
