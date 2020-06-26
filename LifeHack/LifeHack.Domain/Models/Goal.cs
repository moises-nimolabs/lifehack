using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace LifeHack.Domain.Models
{
    public class Goal
    {
        [JsonProperty("id")]
        public long Id { get; set; }
        [JsonProperty("name")]
        public string Name { get; set; }
        [JsonProperty("goals")]
        public List<Goal> Goals { get; set; }
    }
}
