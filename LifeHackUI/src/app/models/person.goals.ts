import {Goal} from './goal';
import {Person} from './person';

export interface PersonGoals {
  availableGoals: Goal[];
  person: Person;
}
